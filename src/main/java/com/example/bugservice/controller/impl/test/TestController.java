package com.example.bugservice.controller.impl.test;

import com.example.bugservice.controller.datamodel.UserDataModel;
import com.example.bugservice.core.service.UserService;
import com.example.bugservice.persistence.entity.Permission;
import com.example.bugservice.persistence.entity.Role;
import com.example.bugservice.persistence.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @PersistenceContext
    private EntityManager em;

    @GetMapping(path = "/createTestData")
    @Transactional
    public String createTestData() {
        Permission userManagement = new Permission();
        userManagement.setType("USER_MANAGEMENT");
        userManagement.setDescription("CRUD on users");
        em.persist(userManagement);

        Permission permissionManagemenet = new Permission();
        permissionManagemenet.setType("PERMISSION_MANAGEMENT");
        permissionManagemenet.setDescription("CRUD on permissions");
        em.persist(permissionManagemenet);

        Permission bugManagement = new Permission();
        bugManagement.setType("BUG_MANAGEMENT");
        bugManagement.setDescription("CRUD on bugs");
        em.persist(bugManagement);

        Role admin = new Role();
        admin.setType("ADMINISTRATOR");
        em.persist(admin);
        admin.setPermissions(List.of(userManagement,bugManagement,permissionManagemenet));

        User user = new User();
        user.setUsername("ciurec");
        user.setFirstName("Catalin");
        user.setLastName("Ciurean");
        user.setEmail("ciurean@testmail.com");
        user.setMobileNumber("076412345");
        user.setPassword("password");
        em.persist(user);
        user.setRoles(List.of(admin));
        return "Test data created";
    }
}
