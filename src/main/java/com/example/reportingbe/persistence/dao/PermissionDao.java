package com.example.reportingbe.persistence.dao;

import com.example.reportingbe.persistence.entity.Permission;


public interface PermissionDao {


    public Permission createPermission(Permission p);

    public String removePermission(long id);
}
