package com.example.bugservice.persistence.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = User.USER_FIND_BY_EMAIL, query = "SELECT count(u) from User u where u.email = :" + User.EMAIL),

        @NamedQuery(name = User.USER_FIND_ALL, query = "SELECT u from User u"),
        @NamedQuery(name = User.USER_FIND_BY_ID, query = "SELECT u from User u where u.id = :id"),
        @NamedQuery(name = User.USER_FIND_BY_USERNAME, query = "SELECT u from User u where u.username = :username"),
        @NamedQuery(name = User.USER_GET_BY_EMAIL, query = "SELECT u from User u where u.email = :" + User.EMAIL),
})

public class User extends BaseEntity<Long> {

    public static final String USER_FIND_BY_EMAIL = "UserEntity.findByEmail";
    public static final String USER_GET_BY_EMAIL = "UserEntity.getByEmail";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String USER_COUNT_BY_USERNAME = "UserEntity.countByUsername";
    public static final String USER_FIND_ALL = "UserEntity.findAll";
    public static final String USER_FIND_BY_ID = "UserEntity.findById";
    public static final String USER_FIND_BY_USERNAME = "UserEntity.findByUsername";
    public static final String GET_USERS_BY_PERMISSIONS = "UserEntity.findByPermissions";

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "status")
    private int status;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false))
    private List<Role> roles = new ArrayList<>();

}
