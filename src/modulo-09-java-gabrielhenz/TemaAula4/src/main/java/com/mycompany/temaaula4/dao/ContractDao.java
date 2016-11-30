/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula4.dao;

import com.mycompany.temaaula4.entity.Client;
import com.mycompany.temaaula4.entity.Contract;
import javax.persistence.EntityManager;

/**
 *
 * @author Gabriel
 */
public class ContractDao extends AbstractDao<Contract>{
    final EntityManager entityManager;

    public ContractDao(EntityManager entityManager) {
        super(Contract.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
