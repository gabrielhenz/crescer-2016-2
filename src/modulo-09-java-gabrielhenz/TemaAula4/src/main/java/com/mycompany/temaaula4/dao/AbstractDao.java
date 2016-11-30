/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula4.dao;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Gabriel
 */
public abstract class AbstractDao<T> implements IDao<T>{
    
    public abstract EntityManager getEntityManager();

    private final Class<T> clazz;

    public AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void insert(T t) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(T t) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }
    
    @Override
    public void update(T t) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.format("Erro: %s", e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
     public List<T> findAll() {
        return this.getEntityManager().createNamedQuery(clazz.getSimpleName()+".findAll").getResultList();
    }

}
