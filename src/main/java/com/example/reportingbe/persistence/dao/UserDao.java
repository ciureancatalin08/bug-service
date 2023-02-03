package com.example.reportingbe.persistence.dao;

import com.example.reportingbe.persistence.entity.User;

public interface UserDao {

    /**
     * Persists a user entity.
     *
     * @param user the input entity to be saved.
     * @return the persisted entity.
     */
    User createUser(User user);

    User getUserById(long userId);

    User getUserByUsername(String username);
}
