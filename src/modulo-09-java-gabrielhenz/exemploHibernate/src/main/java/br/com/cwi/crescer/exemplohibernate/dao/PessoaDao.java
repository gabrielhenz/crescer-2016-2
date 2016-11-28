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
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import static org.hibernate.criterion.MatchMode.ANYWHERE;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author gabriel.henz
 */
public class PessoaDao implements IDao<Pessoa, Long>{

    final private EntityManager em;
    
    public PessoaDao(EntityManager entityManager){
        this.em = entityManager;
    }
    
    @Override
    public void insert(Pessoa t) {
        
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
    public Pessoa find(Long id) {
        return em.find(Pessoa.class, id);
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
    
    public List<Pessoa> findByName(String nmPessoa) {
       final Session session = em.unwrap(Session.class);
       Criteria criteria = session.createCriteria(Pessoa.class);
       //ANYWHERE -> insere %% entre o nome
       criteria.add(Restrictions.like("nmPessoa", nmPessoa, ANYWHERE));
       return criteria.list();
    }
    
    public List<Pessoa> findByPessoa(Pessoa pessoa) {
       final Session session = em.unwrap(Session.class);
       Criteria criteria = session.createCriteria(Pessoa.class);
       criteria.add(Example.create(pessoa));
       return criteria.list();
    }
    
}

