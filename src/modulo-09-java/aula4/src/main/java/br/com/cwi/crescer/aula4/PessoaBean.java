package br.com.cwi.crescer.aula4;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Carlos H. Nonnemacher
 */
@Stateless
public class PessoaBean {

    @PersistenceContext(unitName = "CRESCER")
    private EntityManager entityManager;
    
    
    
}
