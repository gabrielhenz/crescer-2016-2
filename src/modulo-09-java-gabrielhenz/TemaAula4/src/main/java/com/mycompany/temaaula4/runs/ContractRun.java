/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula4.runs;

import com.mycompany.temaaula4.dao.ClientDao;
import com.mycompany.temaaula4.dao.ContractDao;
import com.mycompany.temaaula4.entity.Client;
import com.mycompany.temaaula4.entity.Contract;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gabriel
 */
public class ContractRun {
    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        
        ContractDao cDao = new ContractDao(em);
        
        Contract c = new Contract(
                null, 
                "Contrato de estágio na empresa CWI Software", 
                "RS", 
                "http://www.roverinformatica.com.br/", 
                "Gabriel Henz contrato");
        
        cDao.insert(c);

        imprimirUsuarios(cDao.findAll());
        
        c.setDsDescription("Contrato de efetivação na empresa CWI Software");
        
        cDao.update(c);

        imprimirUsuarios(cDao.findAll());
        
        cDao.delete(c);
        
        imprimirUsuarios(cDao.findAll());
        
        em.close();
        emf.close();
        
    }
    
    static void imprimirUsuarios(List<Contract> contratos){
        if(contratos.isEmpty()){
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            contratos.forEach((umContrato) -> {
                System.out.println(umContrato.toString());
            });
        }
    }
}
