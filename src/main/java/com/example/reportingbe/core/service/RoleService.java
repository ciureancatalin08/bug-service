package com.example.reportingbe.core.service;

import com.example.reportingbe.controller.datamodel.PermissionDataModel;
import com.example.reportingbe.controller.datamodel.RolePermissionDataModel;
import com.example.reportingbe.persistence.entity.Role;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface RoleService {

    List<Role> getRolesByTypeList(List<String> typeList);

    List<String> getAllRoles();

    List<RolePermissionDataModel> getAllRolesAndLinkedPermissions();

    void deletePermissionFromRole(long roleId, long permissionId);

    List<PermissionDataModel> getPermissionsNotFromRole(long roleId);

    void addPermissionToRole(long roleId, long permissionId);
}

