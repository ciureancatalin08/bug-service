// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package com.example.bugservice.persistence.dao.impl;

import com.example.bugservice.persistence.dao.PermissionDao;
import com.example.bugservice.persistence.entity.Permission;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class PermissionDaoImpl implements PermissionDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Permission createPermission(Permission p) {
        em.persist(p);
        return p;
    }

    @Override
    public String removePermission(long id) {
        return null;
    }
}
