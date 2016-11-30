/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula4.dao;

import com.mycompany.temaaula4.entity.Contract;
import com.mycompany.temaaula4.entity.ContractValue;
import javax.persistence.EntityManager;

/**
 *
 * @author Gabriel
 */
public class ContractValueDao extends AbstractDao<ContractValue>{
    final EntityManager entityManager;

    public ContractValueDao(EntityManager entityManager) {
        super(ContractValue.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
