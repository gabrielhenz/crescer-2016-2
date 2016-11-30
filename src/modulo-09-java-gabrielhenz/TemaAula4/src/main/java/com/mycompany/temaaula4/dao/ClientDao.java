/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula4.dao;

import com.mycompany.temaaula4.entity.Client;
import com.mycompany.temaaula4.entity.Usuario;
import javax.persistence.EntityManager;

/**
 *
 * @author Gabriel
 */
public class ClientDao extends AbstractDao<Client>{

   final EntityManager entityManager;

    public ClientDao(EntityManager entityManager) {
        super(Client.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
}
