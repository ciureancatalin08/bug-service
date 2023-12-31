package com.example.bugservice.persistence.dao.impl;


import com.example.bugservice.persistence.dao.BugDao;
import com.example.bugservice.persistence.entity.Bug;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class BugDaoImpl implements BugDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Bug createBug(Bug bug) {
        em.persist(bug);
        return bug;
    }

    public List<Bug> getAll() {
        return em.createNamedQuery(Bug.BUG_GET_ALL, Bug.class).getResultList();
    }

    public void updateBug(Bug newBug) {
        em.merge(newBug);


    }

    public Bug getById(long id){
        return em.createNamedQuery(Bug.BUG_FIND_BY_ID, Bug.class)
                .setParameter("id", id).getSingleResult();
    }

}
