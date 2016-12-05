/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula5.mbean;

import br.com.cwi.crescer.aula5.bean.ClassificacaoBean;
import br.com.cwi.crescer.aula5.bean.UserBean;
import br.com.cwi.crescer.aula5.dao.ClassificacaoDao;
import br.com.cwi.crescer.aula5.dao.UserDao;
import br.com.cwi.crescer.aula5.entity.Classificacao;
import br.com.cwi.crescer.aula5.entity.User;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Gabriel
 */
@ManagedBean
@ViewScoped
public class CadastroUserMBean extends AbstractMBean<User, Long, UserDao, UserBean> {
    
    @EJB
    private UserBean userBean;

    @PostConstruct
    public void init() {
        this.limpar();
    }
    
    @Override
    public UserBean getBean() {
        return userBean;
    }

    @Override
    public void limpar() {
        this.setEntity(new User());
        this.setList(this.getBean().findAll());
    }

}

