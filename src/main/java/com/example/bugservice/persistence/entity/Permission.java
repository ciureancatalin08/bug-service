package com.example.bugservice.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "permissions")
@NamedQueries({
        @NamedQuery(name = Permission.PERMISSION_FIND_BY_ID,
                query = "select p from Permission p where p.id= :" + Permission.INPUT_ID),
        @NamedQuery(name = Permission.PERMISSION_FIND_ALL, query = "SELECT p from Permission p"),
})
@Getter
@Setter
public class Permission extends BaseEntity<Long> {

    public static final String INPUT_ID = "id";
    public static final String PERMISSION_FIND_BY_ID = "PermissionEntity.findById";
    public static final String PERMISSION_FIND_ALL = "PermissionEntity.findAll";
    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

}
