/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula4.dao;

import com.mycompany.temaaula4.entity.Cotacao;
import com.mycompany.temaaula4.entity.CurrencyExchange;
import javax.persistence.EntityManager;

/**
 *
 * @author Gabriel
 */
public class CurrencyExchangeDao extends AbstractDao<CurrencyExchange>{
    final EntityManager entityManager;

    public CurrencyExchangeDao(EntityManager entityManager) {
        super(CurrencyExchange.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
