/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5.dao;

import br.com.cwi.crescer.aula5.entity.User;
import javax.persistence.EntityManager;

/**
 *
 * @author Gabriel
 */
public class UserDao extends AbstractDao<User, Long> {

    final EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        super(User.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    public User findByEmail(String email){
        return this.entityManager.find(User.class, email);
    }

}
