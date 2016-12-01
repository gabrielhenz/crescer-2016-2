/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula4.runs;

import com.mycompany.temaaula3.MeuSQLUtils;
import com.mycompany.temaaula4.dao.CotacaoDao;
import com.mycompany.temaaula4.dao.CurrencyExchangeDao;
import com.mycompany.temaaula4.entity.Cotacao;
import com.mycompany.temaaula4.entity.CurrencyExchange;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gabriel
 */
public class CurrencyExchangeRun {
    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        
        CurrencyExchangeDao cDao = new CurrencyExchangeDao(em);
        
        byte []x = new byte[1];
        
        x[0] = 12;
        
        CurrencyExchange c = new CurrencyExchange(
                null, 
                "Euro", 
                x, 
                new BigDecimal("4.12"));
        
        cDao.insert(c);

        imprimirCurrencyExchanges(cDao.findAll());
        
        c.setDsCoin("Dólar");
        
        cDao.update(c);

        imprimirCurrencyExchanges(cDao.findAll());
        
//        cDao.delete(c);
//        imprimirCurrencyExchanges(cDao.findAll());
        
        new MeuSQLUtils().exportarCsv("CURRENCY_EXCHANGE", "currencyExchange.csv");

        em.close();
        emf.close();
        
    }
    
    static void imprimirCurrencyExchanges(List<CurrencyExchange> currencyExchanges){
        if(currencyExchanges.isEmpty()){
            System.out.println("Nenhum câmbio monetário cadastrado.");
        } else {
            currencyExchanges.forEach((umCurrencyExchange) -> {
                System.out.println(umCurrencyExchange.toString());
            });
        }
    }
}
