// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package com.example.reportingbe.persistence.dao.impl;

import com.example.reportingbe.persistence.dao.PermissionDao;
import com.example.reportingbe.persistence.dao.RoleDao;
import com.example.reportingbe.persistence.entity.Permission;
import com.example.reportingbe.persistence.entity.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


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
