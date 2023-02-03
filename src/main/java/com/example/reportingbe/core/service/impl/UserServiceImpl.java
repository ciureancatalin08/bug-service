package com.example.reportingbe.core.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.reportingbe.controller.datamodel.UserDataModel;
import com.example.reportingbe.controller.datamodel.UserLoginDataModel;
import com.example.reportingbe.controller.datamodel.UserLoginOutputDatenModel;
import com.example.reportingbe.core.service.UserService;
import com.example.reportingbe.persistence.dao.UserDao;
import com.example.reportingbe.persistence.dao.impl.UserDaoImpl;
import com.example.reportingbe.persistence.entity.Permission;
import com.example.reportingbe.persistence.entity.Role;
import com.example.reportingbe.persistence.entity.User;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDao;

    private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    @Override
    public UserDataModel createUser(UserDataModel userDataModel) {

        mapperFactory.classMap(UserDataModel.class, User.class);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        User user = mapper.map(userDataModel, User.class);

        return mapper.map(userDao.createUser(user), UserDataModel.class);
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
}
