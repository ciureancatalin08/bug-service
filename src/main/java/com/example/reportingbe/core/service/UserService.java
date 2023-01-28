package com.example.reportingbe.core.service;

import com.example.reportingbe.controller.datamodel.UserDataModel;

public interface UserService {

    UserDataModel createUser(UserDataModel userDataModel);

    UserDataModel getUserById(long id);
}
