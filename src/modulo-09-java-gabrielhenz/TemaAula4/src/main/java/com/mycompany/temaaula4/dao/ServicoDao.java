/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula4.dao;

import com.mycompany.temaaula4.entity.Servico;
import javax.persistence.EntityManager;

/**
 *
 * @author Gabriel
 */
public class ServicoDao extends AbstractDao<Servico>{
    final EntityManager entityManager;

    public ServicoDao(EntityManager entityManager) {
        super(Servico.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
