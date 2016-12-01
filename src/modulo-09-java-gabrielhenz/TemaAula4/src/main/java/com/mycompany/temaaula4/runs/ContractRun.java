/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula4.runs;

import com.mycompany.temaaula3.MeuSQLUtils;
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
        
        c.setClientIdClient(new ClientDao(em).findAll().get(0));
        
        cDao.insert(c);

        imprimirContracts(cDao.findAll());
        
        c.setDsDescription("Contrato de efetivação na empresa CWI Software");
        
        cDao.update(c);

        imprimirContracts(cDao.findAll());
        
//        cDao.delete(c);
//        imprimirContracts(cDao.findAll());
        
        new MeuSQLUtils().exportarCsv("CONTRACT", "contract.csv");
        
        em.close();
        emf.close();
        
    }
    
    static void imprimirContracts(List<Contract> contratos){
        if(contratos.isEmpty()){
            System.out.println("Nenhum contrato cadastrado.");
        } else {
            contratos.forEach((umContrato) -> {
                System.out.println(umContrato.toString());
            });
        }
    }
}
