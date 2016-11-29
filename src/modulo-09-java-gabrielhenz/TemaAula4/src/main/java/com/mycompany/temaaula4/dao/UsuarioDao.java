/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula4.dao;

import com.mycompany.temaaula4.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import org.eclipse.persistence.sessions.Session;

/**
 *
 * @author Gabriel
 */

public class UsuarioDao implements IDao<Usuario>{

    final private EntityManager em;
    
    public UsuarioDao(EntityManager em){
        this.em = em;
    }
    
    @Override
    public void insert(Usuario t) {
        
        if(em.isOpen()){
            em.getTransaction().begin();
            try{
                em.persist(t);
                em.getTransaction().commit();
            }catch(Exception e){
                em.getTransaction().rollback();
            }
        }
    }

    @Override
    public void delete(Usuario t) {
        if(em.isOpen()){
            em.getTransaction().begin();
            try{
            em.remove(t);
            em.getTransaction().commit();
            }catch(Exception e){
                em.getTransaction().rollback();
            }
        }
    }

    @Override
    public List<Usuario> findAll() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public void update(Usuario t) {
        Session session = em.unwrap(Session.class);
//        session.update("Usuario", t);
    }
    
}
