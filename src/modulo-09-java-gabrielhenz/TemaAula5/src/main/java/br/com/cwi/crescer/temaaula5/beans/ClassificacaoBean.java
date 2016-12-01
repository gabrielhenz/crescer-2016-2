/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.temaaula5.beans;

import br.com.cwi.crescer.temaaula5.entities.Ator;
import br.com.cwi.crescer.temaaula5.entities.Classificacao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Gabriel
 */
@Stateless
public class ClassificacaoBean extends AbstractBean<Classificacao>{

    @PersistenceContext(unitName = "CRESCER")
    private EntityManager entityManager;

    public ClassificacaoBean() {
        super(Classificacao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
