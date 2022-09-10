package com_spring_springboot.dao;

import com_spring_springboot.models.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> printUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        user.setName(user.getName());
        user.setAge(user.getAge());
        entityManager.merge(user);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(getById(user.getId()));
    }
}
