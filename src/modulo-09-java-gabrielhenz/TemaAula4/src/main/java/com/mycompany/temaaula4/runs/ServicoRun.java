/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula4.runs;

import com.mycompany.temaaula3.MeuSQLUtils;
import com.mycompany.temaaula4.dao.CurrencyExchangeDao;
import com.mycompany.temaaula4.dao.ServicoDao;
import com.mycompany.temaaula4.dao.UsuarioDao;
import com.mycompany.temaaula4.entity.CurrencyExchange;
import com.mycompany.temaaula4.entity.Servico;
import com.mycompany.temaaula4.entity.Usuario;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gabriel
 */
public class ServicoRun {
    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        
        ServicoDao sDao = new ServicoDao(em);
        
        Servico s = new Servico(
                null, 
                "Servico de teste que nao serve pra nada.", 
                "Um por ano", 
                "$", 
                "Nao sei o que colocar aqui", 
                "www.roverinformatica.com", 
                "Serviço de teste", 
                new BigDecimal("12.12"), 
                new BigDecimal("10.10"));
        
        Usuario usuario = new UsuarioDao(em).findAll().get(0);
        
        if(usuario != null){
            s.setUsuarioIdUsuario(usuario);
        }
        
        sDao.insert(s);

        imprimirServicos(sDao.findAll());
        
        s.setDsDescricao("Setar descricao de novo");
        
        sDao.update(s);

        imprimirServicos(sDao.findAll());
        
//        cDao.delete(s);
//        imprimirServicos(cDao.findAll());
        
        new MeuSQLUtils().exportarCsv("SERVICO", "servico.csv");

        em.close();
        emf.close();
        
    }
    
    static void imprimirServicos(List<Servico> servicos){
        if(servicos.isEmpty()){
            System.out.println("Nenhum câmbio monetário cadastrado.");
        } else {
            servicos.forEach((umServico) -> {
                System.out.println(umServico.toString());
            });
        }
    }
}
