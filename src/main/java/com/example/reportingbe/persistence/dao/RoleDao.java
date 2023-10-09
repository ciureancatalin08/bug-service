// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package com.example.reportingbe.persistence.dao;

import com.example.reportingbe.controller.datamodel.PermissionDataModel;
import com.example.reportingbe.controller.datamodel.RolePermissionDataModel;
import com.example.reportingbe.persistence.entity.Role;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface RoleDao {

    Role getRolesById(final long roleId);

    List<String> getAllRoles();

    List<Role> getAllRolesAndLinkedPermissions();

    List<Role> getRolesByTypeList(final List<String> typeList);

    List<PermissionDataModel> getPermissionsNotFromRole(long roleId);
    void addPermissionToRole(long roleId, long permissionId);
}
