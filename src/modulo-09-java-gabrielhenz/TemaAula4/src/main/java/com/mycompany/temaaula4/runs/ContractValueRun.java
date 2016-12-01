/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula4.runs;

import com.mycompany.temaaula3.MeuSQLUtils;
import com.mycompany.temaaula4.dao.ClientDao;
import com.mycompany.temaaula4.dao.ContractDao;
import com.mycompany.temaaula4.dao.ContractValueDao;
import com.mycompany.temaaula4.entity.Client;
import com.mycompany.temaaula4.entity.Contract;
import com.mycompany.temaaula4.entity.ContractValue;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gabriel
 */
public class ContractValueRun {
    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        
        ContractValueDao cvDao = new ContractValueDao(em);
        
        ContractValue cv = new ContractValue(
                null, 
                "Real", 
                "Ano", 
                new BigDecimal("100.12"), 
                new BigDecimal("555.55"));
        
        Contract contract = new ContractDao(em).findAll().get(0);
        if(contract != null){
            cv.setContractIdContract(contract);
        }
        
        cvDao.insert(cv);

        imprimirContractValues(cvDao.findAll());
        
        cv.setDsCoin("Euro");
        
        cvDao.update(cv);

        imprimirContractValues(cvDao.findAll());
        
//        cvDao.delete(c);
//        imprimirContractValues(cvDao.findAll());
        
        new MeuSQLUtils().exportarCsv("CONTRACT_VALUE", "contractValue.csv");

        em.close();
        emf.close();
        
    }
    
    static void imprimirContractValues(List<ContractValue> valoresDeContratos){
        if(valoresDeContratos.isEmpty()){
            System.out.println("Nenhum valor de contrato cadastrado.");
        } else {
            valoresDeContratos.forEach((umValorDeContrato) -> {
                System.out.println(umValorDeContrato.toString());
            });
        }
    }
}
