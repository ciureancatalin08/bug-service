package com.example.reportingbe.controller.impl;

import com.example.reportingbe.core.service.BugService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController
public class BugControllerImpl implements BugService {
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response createBug(@Context SecurityContext securityContext, BugInputDTO input) {
////        if (securityContext.isUserInRole(String.valueOf(PermissionType.BUG_MANAGEMENT))) {
////            facade.createBug(input);
////            return Response.ok().build();
////        } else {
////            return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
////        }
//    }
//
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response updateBug(@Context SecurityContext securityContext, Bug input) {
////        if (securityContext.isUserInRole(String.valueOf(PermissionType.BUG_MANAGEMENT))) {
////            if (securityContext.isUserInRole(String.valueOf(PermissionType.BUG_CLOSE))) {
////                facade.updateBug(input, StatusUpdate.allStatusValue);
////            }else{
////                facade.updateBug(input, StatusUpdate.limitedStatusValue);
////            }
////            return Response.ok().build();
////        } else {
////            return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
////        }
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getAll(@Context SecurityContext securityContext) {
//        if (securityContext.isUserInRole(String.valueOf(PermissionType.BUG_MANAGEMENT))) {
//            return Response.status(200).entity(facade.getAll()).build();
//        } else {
//            return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
//
//        }
//    }
//
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/status-limited/{status}")
//    @GET
//    public Response getStatusLimited(@Context SecurityContext securityContext, @PathParam("status") String status) {
//        if (securityContext.isUserInRole(String.valueOf(PermissionType.BUG_MANAGEMENT))) {
//            return Response.ok(facade.getStatusBugLimited(status)).build();
//        } else
//            return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
//    }
//
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/status-all/{status}")
//    @GET
//    public Response getStatusAll(@Context SecurityContext securityContext, @PathParam("status") String status) {
//        if (securityContext.isUserInRole(String.valueOf(PermissionType.BUG_CLOSE))) {
//            return Response.ok(facade.getStatusBugComplete(status)).build();
//        } else
//            return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
//    }
//    @Produces(MediaType.APPLICATION_JSON)
//
//    @Path("/statistics")
//    @GET
//    public Response getStatistics(@Context SecurityContext securityContext) {
//        if (securityContext.isUserInRole(String.valueOf(PermissionType.BUG_MANAGEMENT))) {
//            return Response.ok(facade.getStatistics()).build();
//        } else
//            return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
//    }

}
