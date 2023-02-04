package com.example.reportingbe.persistence.dao;

import com.example.reportingbe.persistence.entity.User;

public interface UserDao {


    User createUser(User user);

    User getUserById(long userId);

    User getUserByUsername(String username);
}
