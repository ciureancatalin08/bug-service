// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package com.example.reportingbe.persistence.dao;

import com.example.reportingbe.persistence.entity.Role;

import java.util.List;


public interface RoleDao {

    List<Role> getRolesByTypeList(final List<String> typeList);

    List<String> getAllRoles();

}
