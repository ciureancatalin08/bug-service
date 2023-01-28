package com.example.reportingbe.persistence.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
//@NamedQueries({
//        @NamedQuery(name = RoleEntity.GET_PERMISSIONSANDROLES,
//                query = "select r from RoleEntity r"),
//        @NamedQuery(name = RoleEntity.GET_PERMISSIONS,
//                query = "select r.permissions from RoleEntity r where r.id in :" + RoleEntity.ID_PERM),
//        @NamedQuery(name = RoleEntity.QUERY_GET_ROLES_BY_TYPE_LIST,
//                query = "select r from RoleEntity r " + "where r.type in :" + RoleEntity.INPUT_TYPE_LIST),
//        @NamedQuery(name = RoleEntity.GET_ALL_ROLES_TYPE,
//                query = "SELECT r.type from RoleEntity r "),
//        @NamedQuery(name = RoleEntity.QUERY_GET_ROLE_BY_ID,
//                query = "select r from RoleEntity r "
//                        + "where r.id = :" + RoleEntity.INPUT_ID)})
public class Role extends BaseEntity<Long> {

    //    public static final String QUERY_GET_ROLE_BY_ID = "getRoleById";
//    public static final String QUERY_GET_ROLES_BY_TYPE_LIST = "getRolesByTypeList";
//    public static final String INPUT_TYPE_LIST = "type";
//    public static final String INPUT_ID = "id";
//    public static final String ID_PERM = "id";
//    public static final String GET_ALL_ROLES_TYPE = "getAllRolesType";
//    public static final String GET_PERMISSIONS = "getPermissions";
//    public static final String GET_PERMISSIONSANDROLES = "getAllRolesAndPermissions";
    @Column(name = "type", nullable = false)
    private String type;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "roles_permissions",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id", nullable = false)
    )
    private List<Permission> permissions = new ArrayList<>();


}
