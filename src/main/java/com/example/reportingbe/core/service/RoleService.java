package com.example.reportingbe.core.service;

import com.example.reportingbe.persistence.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> getRolesByTypeList(List<String> typeList);

    List<String> getAllRoles();
}

