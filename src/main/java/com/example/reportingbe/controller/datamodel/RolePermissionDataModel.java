package com.example.reportingbe.controller.datamodel;

import com.example.reportingbe.persistence.entity.Permission;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RolePermissionDataModel {

    private long roleId;
    private String name;

    private List<PermissionDataModel> permissions;


}
