/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.exemplohibernate.dao;

import br.com.cwi.crescer.exemploHibernate.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author gabriel.henz
 */
public class NovoClass implements IDao<Pessoa, Long>{

    final private EntityManager em;
    
    public NovoClass(EntityManager entityManager){
        this.em = entityManager;
    }
    
    @Override
    public void insert(Pessoa t) {
        
        if(em.isOpen()){
            em.getTransaction().begin();
            try{
                            
            final Pessoa pessoa = new Pessoa();
            pessoa.setIdPessoa(1l);
            pessoa.setNmPessoa("Gabriel Henz");
            
            em.persist(pessoa);
            em.getTransaction().commit();
            }catch(Exception e){
                em.getTransaction().rollback();
            }
        }
    }

    @Override
    public Pessoa find(Long id) {
        final Pessoa pessoa = em.find(Pessoa.class, id);
        return pessoa;
    }

    @Override
    public void delete(Pessoa t) {
        
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
    public List<Pessoa> findAll() {
        return em.createQuery("select p from Pessoa p").getResultList();
    }
    
    public List<Pessoa> findByName(String nmPessoa){
        final Query query = em.createQuery("select p from Pessoa p where upper(p.nmPessoa) like :nmPessoa");
        query.setParameter("nmPessoa", ("%"+nmPessoa+"%").toUpperCase());
        return query.getResultList();
    }
    
}

