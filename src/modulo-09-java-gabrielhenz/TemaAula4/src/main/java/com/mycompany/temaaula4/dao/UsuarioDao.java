/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula4.dao;

import com.mycompany.temaaula4.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import org.eclipse.persistence.sessions.Session;

/**
 *
 * @author Gabriel
 */

public class UsuarioDao extends AbstractDao<Usuario>{

    final EntityManager entityManager;

    public UsuarioDao(EntityManager entityManager) {
        super(Usuario.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
