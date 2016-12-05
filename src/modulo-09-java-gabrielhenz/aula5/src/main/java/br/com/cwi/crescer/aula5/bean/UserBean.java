/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5.bean;

import br.com.cwi.crescer.aula5.dao.UserDao;
import br.com.cwi.crescer.aula5.entity.User;
import javax.ejb.Stateless;

/**
 *
 * @author Gabriel
 */
@Stateless
public class UserBean extends AbstractBean<User, Long, UserDao> {

    private UserDao dao;

    @Override
    public UserDao getDao() {
        if (dao == null) {
            dao = new UserDao(this.getEntityManager());
        }
        return dao;
    }

}
