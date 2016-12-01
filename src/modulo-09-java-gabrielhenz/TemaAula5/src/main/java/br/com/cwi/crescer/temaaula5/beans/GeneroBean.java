/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.temaaula5.beans;

import br.com.cwi.crescer.temaaula5.entities.Filme;
import br.com.cwi.crescer.temaaula5.entities.Genero;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Gabriel
 */
@Stateless
public class GeneroBean extends AbstractBean<Genero>{

    @PersistenceContext(unitName = "CRESCER")
    private EntityManager entityManager;

    public GeneroBean() {
        super(Genero.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}

