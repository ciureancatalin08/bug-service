// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package com.example.reportingbe.persistence.dao.impl;

import com.example.reportingbe.persistence.dao.RoleDao;
import com.example.reportingbe.persistence.entity.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Role> getRolesByTypeList(final List<String> typeList) {
        return em.createNamedQuery(Role.QUERY_GET_ROLES_BY_TYPE_LIST, Role.class)
                .setParameter(Role.INPUT_TYPE_LIST, typeList)
                .getResultList();
    }

}
