/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula4.dao;

import com.mycompany.temaaula4.entity.ContractValue;
import com.mycompany.temaaula4.entity.Cotacao;
import javax.persistence.EntityManager;

/**
 *
 * @author Gabriel
 */
public class CotacaoDao extends AbstractDao<Cotacao>{
    final EntityManager entityManager;

    public CotacaoDao(EntityManager entityManager) {
        super(Cotacao.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
