/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.exemplohibernate;

import br.com.cwi.crescer.exemploHibernate.entity.Pessoa;
import br.com.cwi.crescer.exemplohibernate.dao.PessoaDao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gabriel.henz
 */
public class Run {
    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        
        PessoaDao pessoaDao = new PessoaDao(em);
        
        Pessoa insert = new Pessoa();
        insert.setNmPessoa("Gabriel Henz");
        
        pessoaDao.insert(insert);
        
        pessoaDao.findAll().forEach(p -> System.out.println(p.getNmPessoa()));
        
        em.close();
        emf.close();
    }
}
