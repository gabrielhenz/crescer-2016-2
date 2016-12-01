/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula4.runs;

import com.mycompany.temaaula3.MeuSQLUtils;
import com.mycompany.temaaula4.dao.ServicoDao;
import com.mycompany.temaaula4.dao.UsuarioDao;
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
public class UsuarioRun {
     public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        
        UsuarioDao uDao = new UsuarioDao(em);
        
        Usuario u = new Usuario(
                null, 
                "dhenz109@gmail.com", 
                "12345", 
                "Solteiro", 
                "dhenz", 
                "Delmar Henz", 
                "admin");
        
        uDao.insert(u);

        imprimirUsuarios(uDao.findAll());
        
        u.setDsEmail("dhenz@gmail.com");
        
        uDao.update(u);

        imprimirUsuarios(uDao.findAll());
        
//        cDao.delete(u);
//        imprimirUsuarios(cDao.findAll());
        
        new MeuSQLUtils().exportarCsv("USUARIO", "usuario.csv");

        em.close();
        emf.close();
        
    }
    
    static void imprimirUsuarios(List<Usuario> usuarios){
        if(usuarios.isEmpty()){
            System.out.println("Nenhum câmbio monetário cadastrado.");
        } else {
            usuarios.forEach((umUsuario) -> {
                System.out.println(umUsuario.toString());
            });
        }
    }
}
