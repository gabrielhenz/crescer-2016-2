/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula4.runs;

import com.mycompany.temaaula3.MeuSQLUtils;
import com.mycompany.temaaula4.dao.ClientDao;
import com.mycompany.temaaula4.dao.CotacaoDao;
import com.mycompany.temaaula4.entity.Client;
import com.mycompany.temaaula4.entity.Cotacao;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gabriel
 */
public class CotacaoRun {
    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        
        CotacaoDao cDao = new CotacaoDao(em);
        
        byte []x = new byte[1];
        
        x[0] = 12;
        
        Cotacao c = new Cotacao(
                null, 
                new BigDecimal("3.27"), 
                new BigDecimal("4.34"), 
                new BigDecimal("5.02"), 
                new BigDecimal("6.11"), 
                new BigDecimal("7.65"), 
                new BigDecimal("12.09"), 
                new BigDecimal("2.63"), 
                new BigDecimal("1.21"),
                x);
        
        cDao.insert(c);

        imprimirCotacoes(cDao.findAll());
        
        c.setDsCotacaoYuan(new BigDecimal("10.23"));
        
        cDao.update(c);

        imprimirCotacoes(cDao.findAll());
        
//        cDao.delete(c);
//        imprimirCotacoes(cDao.findAll());
        
        new MeuSQLUtils().exportarCsv("COTACAO", "cotacao.csv");

        em.close();
        emf.close();
        
    }
    
    static void imprimirCotacoes(List<Cotacao> cotacoes){
        if(cotacoes.isEmpty()){
            System.out.println("Nenhuma cotação cadastrada.");
        } else {
            cotacoes.forEach((umaCotacao) -> {
                System.out.println(umaCotacao.toString());
            });
        }
    }
}
