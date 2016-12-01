/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.temaaula5.beans;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Gabriel
 */
public abstract class AbstractBean<T> implements IBean<T>{
    
    public abstract EntityManager getEntityManager();

    private final Class<T> clazz;

    public AbstractBean(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void insert(T t) {
        this.getEntityManager().persist(t);
    }

    @Override
    public void delete(T t) {
        this.getEntityManager().remove(t);
    }

    @Override
    public void update(T t) {
        this.getEntityManager().merge(t);
    }
    
    @Override
    public T find(Long id) {
        return this.getEntityManager().find(clazz, id);
    }
    
    @Override
     public List<T> findAll() {
<<<<<<< HEAD
        String tabela =  clazz.getSimpleName();
        String alias = tabela.substring(0, 1);
        return this.getEntityManager()
                .createQuery(
                        String.format(
                                "SELECT %s FROM %s %s", 
                                alias, 
                                tabela, 
                                alias)
                ).getResultList();
=======
        return this.getEntityManager().createNamedQuery(clazz.getSimpleName()+".findAll").getResultList();
>>>>>>> master
    }

}

