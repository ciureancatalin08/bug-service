package com.example.reportingbe.controller.impl;

import com.example.reportingbe.controller.UserController;
import com.example.reportingbe.controller.datamodel.UserDataModel;
import com.example.reportingbe.controller.datamodel.UserLoginDataModel;
import com.example.reportingbe.controller.datamodel.UserLoginOutputDatenModel;
import com.example.reportingbe.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/jbugs")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;


    @PostMapping(path = "/login/auth",
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON
    )
    public ResponseEntity<UserLoginOutputDatenModel> loginUser(@RequestBody UserLoginDataModel userLoginDataModel) {

        UserLoginOutputDatenModel response = userService.authenticateUser(userLoginDataModel);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PostMapping(path = "/users",
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<String> createUser(@RequestBody UserDataModel user) {

        String response = userService.createUser(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<UserDataModel> getUserById(@RequestParam("id") long id) {

        UserDataModel user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @Consumes(MediaType.APPLICATION_JSON)
//    @PutMapping
//    public Response updateUser(@Context SecurityContext securityContext, UserDataModel userDataModel) {
//        if (securityContext.isUserInRole(String.valueOf(PermissionType.USER_MANAGEMENT))) {
//            userUpdateDTO.setWhoUpdatedHim(securityContext.getUserPrincipal().getName());
//            userService.updateUser(userUpdateDTO);
//            return Response.ok().build();
//        }
//        return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
//    }
//
//    @Path("/password")
//    @PutMapping
//    public Response changePassword(@Context SecurityContext securityContext, UserChangePasswordDTO userChangePasswordDTO) {
//        if (securityContext.isUserInRole(String.valueOf(PermissionType.USER_MANAGEMENT))) {
//            userFacade.changePassword(userChangePasswordDTO);
//            return Response.ok().build();
//        }
//        return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
//    }
//
//    @Path("/{id}")
//    @PutMapping
//    public Response deactivateUser(@Context SecurityContext securityContext, @PathParam("id") long id) {
//        if (securityContext.isUserInRole(String.valueOf(PermissionType.USER_MANAGEMENT))) {
//            userFacade.deactivateUser(id);
//            return Response.ok().build();
//        }
//        return Response.status(Response.Status.FORBIDDEN).build();
//    }
//
//
//    @Produces(MediaType.APPLICATION_JSON)
//    @GetMapping
//    public Response getAll(@Context SecurityContext securityContext) {
//        if (securityContext.isUserInRole(String.valueOf(PermissionType.USER_MANAGEMENT))) {
//            return Response.ok(userFacade.getAll()).build();
//        }
//        return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
//    }


}
