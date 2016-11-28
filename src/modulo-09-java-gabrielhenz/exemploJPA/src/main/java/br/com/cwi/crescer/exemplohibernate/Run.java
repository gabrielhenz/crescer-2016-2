/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.exemplohibernate;

import br.com.cwi.crescer.exemploHibernate.entity.Pessoa;
import br.com.cwi.crescer.exemplohibernate.dao.NovoClass;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gabriel.henz
 */
public class Run {
    public static void main(String[] args) {
        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em;
        em = emf.createEntityManager();
        NovoClass dao = new NovoClass(em);
        Pessoa p = new Pessoa();
        p.setNmPessoa("Gabriel Henz");
        p.setIdPessoa(1l);
        dao.insert(p);
        System.out.println(dao.find(1l));
        em.close();
        emf.close();
    }
}
