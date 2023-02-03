package com.example.reportingbe.persistence.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "permissions")
@NamedQueries({
        @NamedQuery(name = Permission.PERMISSION_FIND_BY_ID,
                query = "select p from Permission p where p.id= :" + Permission.INPUT_ID),
        @NamedQuery(name = Permission.PERMISSION_FIND_ALL, query = "SELECT p from Permission p"),
})
public class Permission extends BaseEntity<Long> {

    public static final String INPUT_ID = "id";
    public static final String PERMISSION_FIND_BY_ID = "PermissionEntity.findById";
    public static final String PERMISSION_FIND_ALL = "PermissionEntity.findAll";
    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

}
