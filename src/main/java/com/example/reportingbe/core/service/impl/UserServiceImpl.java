package com.example.reportingbe.core.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.reportingbe.controller.datamodel.UserDataModel;
import com.example.reportingbe.controller.datamodel.UserLoginDataModel;
import com.example.reportingbe.controller.datamodel.UserLoginOutputDatenModel;
import com.example.reportingbe.core.service.UserService;
import com.example.reportingbe.core.utils.MessageCatalog;
import com.example.reportingbe.core.utils.exceptions.BusinessWebAppException;
import com.example.reportingbe.persistence.dao.impl.UserDaoImpl;
import com.example.reportingbe.persistence.entity.Role;
import com.example.reportingbe.persistence.entity.User;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDao;

    @Autowired
    private RoleServiceImpl roleService;

    private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    @Override
    public String createUser(UserDataModel userDataModel) {

        if (userDataModel.getFirstName() == null || userDataModel.getEmail() == null || userDataModel.getRoles().isEmpty())
            throw new BusinessWebAppException(MessageCatalog.USER_FIELDS_MISSING, 400);

        if (userDao.emailExists(userDataModel.getEmail()))
            throw new BusinessWebAppException(MessageCatalog.USER_WITH_SAME_MAIL_EXISTS, 400);


        final User newUser = createNewUser(userDataModel);

        newUser.setUsername(userDataModel.getFirstName());
        newUser.setStatus(1);
        newUser.setPassword("DEFAULT_PASSWORD");

        try {
            userDao.createUser(newUser);
//            final long id = userDao.getUserByUsername(userDataModel.getEmail()).getId();
//            final String userFullName = newUserEntity.getFirstName() + " " + newUserEntity.getLastName();
//            this.computationService.sendMail(newUserEntity.getEmail(), newUserEntity.getFirstName(), newUserEntity.getUsername(), newUserEntity.getPassword());
//            this.notificationFacade.createNotification(
//                    NotificationType.WELCOME_NEW_USER,
//                    new NotificationParamsWelcomeUser(userFullName, newUserEntity.getUsername()), id);
        } catch (Exception e) {
            throw new BusinessWebAppException(MessageCatalog.USER_INVALID_PATTERN, 400);
        }


        return newUser.getUsername();
    }

    @Override
    public UserDataModel getUserById(long id) {

        mapperFactory.classMap(User.class, UserDataModel.class);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(userDao.getUserById(id), UserDataModel.class);
    }

    @Override
    public UserLoginOutputDatenModel authenticateUser(UserLoginDataModel user) {

        String[] permissions = {"USER_MANAGEMENT", "BUG_MANAGEMENT"};
        User result = userDao.getUserByUsername(user.getUsername());

        if (user != null) {

            //            Set<Permission> permissions = new HashSet<>();
//            for (Role roleEntity : user.getRoles()) {
//                for (PermissionEntity permissionEntity : roleEntity.getPermissions()) {po
//                    permissions.add(permissionEntity);
//                }
//            }
            Algorithm algorithm = Algorithm.HMAC256("harambe");
            String jwt = JWT.create().withIssuer("auth0")
                    .withClaim("id", result.getId())
                    .withClaim("username", user.getUsername())
                    .withArrayClaim("permissions", permissions)
                    .sign(algorithm);

            ArrayList<String> permissionsAsList = new ArrayList<>(Arrays.asList(permissions));


            return new UserLoginOutputDatenModel(result.getEmail(), result.getUsername(), permissionsAsList, jwt);

//        } else {
//            throw new BusinessException(MessageCatalog.USER_INVALID_USERNAME_OR_PASSWORD);
//        }

        }

        return null;
    }


    @Override
    public List<UserDataModel> getAllUsers() {

        mapperFactory.classMap(User.class, UserDataModel.class);
        MapperFacade mapper = mapperFactory.getMapperFacade();

        List<UserDataModel> usersDataModel = new ArrayList<>();
        List<User> users = userDao.getAll();

        for (User user : users) {

            UserDataModel userDataModel = mapper.map(user, UserDataModel.class);
            userDataModel.setRoles(user.getRoles().stream().map(Role::getType).collect(Collectors.toList()));
            usersDataModel.add(userDataModel);
        }
        return usersDataModel;
    }

    public User createNewUser(UserDataModel userDataModel) {

        final User user = new User();
        user.setFirstName(userDataModel.getFirstName());
        user.setLastName(userDataModel.getLastName());
        user.setEmail(userDataModel.getEmail());
        user.setMobileNumber(userDataModel.getMobileNumber());
        user.setRoles(new ArrayList<>());

        if (userDataModel.getRoles() != null && !userDataModel.getRoles().isEmpty()) {
            user.getRoles().addAll(
                    roleService.getRolesByTypeList(userDataModel.getRoles()));
        }

        return user;
    }
}
