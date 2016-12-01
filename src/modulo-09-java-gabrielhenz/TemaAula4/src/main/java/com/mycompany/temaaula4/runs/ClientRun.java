/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula4.runs;

import com.mycompany.temaaula3.MeuSQLUtils;
import com.mycompany.temaaula4.dao.ClientDao;
import com.mycompany.temaaula4.entity.Client;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gabriel
 */
public class ClientRun {
    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        
        ClientDao cDao = new ClientDao(em);
        
        Client c = new Client(
                null, 
                "gabrield47@gmail.com", 
                "crescer", 
                "Dólar", 
                "RS", 
                "gabriel.henz", 
                "Gabriel Dias Henz", 
                "User");
        
        cDao.insert(c);

        imprimirClients(cDao.findAll());
        
        c.setDsEmail("gabriel.henz@cwi.com.br");
        
        cDao.update(c);

        imprimirClients(cDao.findAll());
        
//        cDao.delete(c);
//        imprimirClients(cDao.findAll());
        
        new MeuSQLUtils().exportarCsv("CLIENT", "client.csv");

        em.close();
        emf.close();
        
    }
    
    static void imprimirClients(List<Client> clientes){
        if(clientes.isEmpty()){
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            clientes.forEach((umCliente) -> {
                System.out.println(umCliente.toString());
            });
        }
    }
}
