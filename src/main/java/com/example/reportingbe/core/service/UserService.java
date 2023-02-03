package com.example.reportingbe.core.service;

import com.example.reportingbe.controller.datamodel.UserDataModel;
import com.example.reportingbe.controller.datamodel.UserLoginDataModel;
import com.example.reportingbe.controller.datamodel.UserLoginOutputDatenModel;

public interface UserService {

    UserDataModel createUser(UserDataModel userDataModel);

    UserDataModel getUserById(long id);

    UserLoginOutputDatenModel authenticateUser(UserLoginDataModel user);
}
