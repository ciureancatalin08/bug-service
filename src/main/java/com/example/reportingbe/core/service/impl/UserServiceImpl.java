package com.example.reportingbe.core.service.impl;

import com.example.reportingbe.controller.datamodel.UserDataModel;
import com.example.reportingbe.core.service.UserService;
import com.example.reportingbe.persistence.dao.UserDao;
import com.example.reportingbe.persistence.dao.impl.UserDaoImpl;
import com.example.reportingbe.persistence.entity.User;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
}
