// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package com.example.reportingbe.persistence.dao.impl;

import com.example.reportingbe.controller.datamodel.PermissionDataModel;
import com.example.reportingbe.controller.datamodel.RolePermissionDataModel;
import com.example.reportingbe.persistence.dao.RoleDao;
import com.example.reportingbe.persistence.entity.Permission;
import com.example.reportingbe.persistence.entity.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Role getRolesById(long roleId) {
        return em.createNamedQuery(Role.QUERY_GET_ROLES_BY_ID, Role.class)
                .setParameter("roleId", roleId)
                .getSingleResult();
    }

    @Override
    public List<Role> getAllRolesAndLinkedPermissions() {
        return em.createNamedQuery(Role.GET_ALLROLESANDLINKEDPERMISSIONS, Role.class).getResultList();
    }

    @Override
    public List<String> getAllRoles() {

        return em.createNamedQuery(Role.GET_ALL_ROLES_TYPE, String.class)
                .getResultList();
    }

    @Override
    public List<Role> getRolesByTypeList(final List<String> typeList) {
        return em.createNamedQuery(Role.QUERY_GET_ROLES_BY_TYPE_LIST, Role.class)
                .setParameter(Role.INPUT_TYPE_LIST, typeList)
                .getResultList();
    }

    @Override
    public List<PermissionDataModel> getPermissionsNotFromRole(long roleId) {
        Role roles = getRolesById(roleId);
        List<Permission> allPermissions = em.createNamedQuery(Role.QUERY_GET_ALLPERMISSIONS, Permission.class).getResultList();
        allPermissions.removeAll(roles.getPermissions());
        return allPermissions.stream().map(this::mapPermission).collect(Collectors.toList());
    }

    private PermissionDataModel mapPermission(Permission permission) {

        PermissionDataModel permissionDataModel = new PermissionDataModel();
        permissionDataModel.setName(permission.getType());
        permissionDataModel.setId(permission.getId());
        return permissionDataModel;
    }

    @Override
    public void addPermissionToRole(long roleId, long permissionId) {
        Role role = em.find(Role.class, roleId);
        Permission permission = em.find(Permission.class, permissionId);
        role.getPermissions().add(permission);
    }
}
