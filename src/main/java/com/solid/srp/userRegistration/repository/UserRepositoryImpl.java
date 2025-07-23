package com.solid.srp.userRegistration.repository;

import com.solid.srp.userRegistration.model.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {
    @Inject
    EntityManager em;

    @Transactional
    public void create(User user) {
        em.persist(user);
    }

    @Transactional
    public User getByEmail(String email) {
        return em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    @Transactional
    public void deleteByEmail(String email) {
        User user = getByEmail(email);
        em.remove(user);
    }

}
