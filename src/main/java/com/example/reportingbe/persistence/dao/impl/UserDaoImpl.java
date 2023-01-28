package com.example.reportingbe.persistence.dao.impl;


import com.example.reportingbe.persistence.dao.UserDao;
import com.example.reportingbe.persistence.entity.BaseEntity;
import com.example.reportingbe.persistence.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

//    @PersistenceContext(unitName = "persistenceUnit")
//    private EntityManager em;
//
//    /**
//     * Checks if a email address of a user is in use.
//     *
//     * @param email the email to check for. mandatory
//     * @return <code>true</code> if the input email is associated with a user.
//     */
//    public boolean existsEmail(String email) {
//        long count = em.createNamedQuery(User.USER_FIND_BY_EMAIL, Long.class)
//                .setParameter(User.EMAIL, email)
//                .getSingleResult();
//        return (count > 0);
//    }

    /**
     * Persists a user entity.
     *
     * @param user the input entity to be saved.
     * @return the persisted entity.
     */
    @Transactional
    public User createUser(User user) {

        em.persist(user);
        return user;
    }

    @Override
    public User getUserById(long userId) {

        return em.createNamedQuery(User.USER_FIND_BY_ID, User.class)
                .setParameter("id", userId)
                .getSingleResult();
    }

    //    public User updateUser(User user) {
//        em.merge(user);
//        return user;
//    }
//
//    public User getUserByEmail(String email) {
//        return em.createNamedQuery(User.USER_GET_BY_EMAIL, User.class)
//                .setParameter(User.EMAIL, email)
//                .getSingleResult();
//    }
//
//    public boolean usernameExists(String username) {
//        long count = em.createNamedQuery(User.USER_COUNT_BY_USERNAME, Long.class)
//                .setParameter("username", username)
//                .getSingleResult();
//        return (count > 0);
//    }
//
//    public User getUserByUsername(String username) {
//        return em.createNamedQuery(User.USER_FIND_BY_USERNAME, User.class)
//                .setParameter("username", username)
//                .getSingleResult();
//    }
//
//    public List<User> getAll() {
//        return em.createNamedQuery(User.USER_FIND_ALL, User.class)
//                .getResultList();
//    }
//
//    public User getUserById(long id) {
//        return em.createNamedQuery(User.USER_FIND_BY_ID, User.class)
//                .setParameter("id", id)
//                .getSingleResult();
//    }

}
