package com.example.reportingbe.controller.impl;

import com.example.reportingbe.controller.datamodel.UserDataModel;
import com.example.reportingbe.core.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("jbugs/jbugs-api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/types")
    public ResponseEntity<List<String>> getAllUsers() {

        List<String> roles = roleService.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}
