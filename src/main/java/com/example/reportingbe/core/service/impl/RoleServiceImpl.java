// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package com.example.reportingbe.core.service.impl;

import com.example.reportingbe.persistence.dao.PermissionDao;
import com.example.reportingbe.persistence.dao.RoleDao;
import com.example.reportingbe.persistence.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl {

    @Autowired
    private RoleDao roleDao;

//    @EJB
//    private RoleConverter roleConverter;
//    @EJB
//    private PermissionFacade permissionFacade;
//    @EJB
//    private PermissionConverter permissionConverter;

    @Autowired
    private PermissionDao permissionDao;

    public List<Role> getRolesByTypeList(List<String> typeList) {

        return roleDao.getRolesByTypeList(typeList);
    }

}
