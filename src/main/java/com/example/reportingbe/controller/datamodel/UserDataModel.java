package com.example.reportingbe.controller.datamodel;


import com.example.reportingbe.persistence.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDataModel extends BaseEntity<Long> {


//    @OneToMany(mappedBy = "userEntity")
//    private Set<CommentEntity> comments;
//    @OneToMany(mappedBy = "assignedTo")
//    private Set<BugEntity> assigned;
//    @OneToMany(mappedBy = "createdBy")
//    private Set<BugEntity> created;
//


    private String firstName;

    private String lastName;

    private String email;

    private String mobileNumber;

    private String username;

    private String password;

    private int counter;

    private int status;


//    @ManyToMany(cascade = CascadeType.PERSIST)
//    @JoinTable(name = "users_roles",
//            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false),
//            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
//    )
//    private List<RoleEntity> roles = new ArrayList<>();


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserEntity userEntity = (UserEntity) o;
//        return counter == userEntity.counter &&
//                Objects.equals(firstName, userEntity.firstName) &&
//                Objects.equals(lastName, userEntity.lastName) &&
//                Objects.equals(email, userEntity.email) &&
//                Objects.equals(mobileNumber, userEntity.mobileNumber) &&
//                Objects.equals(username, userEntity.username) &&
//                Objects.equals(password, userEntity.password) &&
//                Objects.equals(status, userEntity.status);
//    }
//
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(firstName, lastName, email, mobileNumber, username, password, counter, status);
//    }
}
