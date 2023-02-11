package com.example.reportingbe.core.service;

import com.example.reportingbe.controller.datamodel.UserDataModel;
import com.example.reportingbe.controller.datamodel.UserLoginDataModel;
import com.example.reportingbe.controller.datamodel.UserLoginOutputDatenModel;

import java.util.List;

public interface UserService {

    String createUser(UserDataModel userDataModel);

    UserDataModel getUserById(long id);

    UserLoginOutputDatenModel authenticateUser(UserLoginDataModel user);

    List<UserDataModel> getAllUsers();
}
