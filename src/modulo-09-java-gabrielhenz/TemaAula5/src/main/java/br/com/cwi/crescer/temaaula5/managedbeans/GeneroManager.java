/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.temaaula5.managedbeans;

import br.com.cwi.crescer.temaaula5.beans.FilmeBean;
import br.com.cwi.crescer.temaaula5.beans.GeneroBean;
import br.com.cwi.crescer.temaaula5.entities.Filme;
import br.com.cwi.crescer.temaaula5.entities.Genero;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Gabriel
 */
@ManagedBean
@ViewScoped
public class GeneroManager {

    @EJB
    private GeneroBean generoBean;
    
    private Genero genero;
    private List<Genero> generos;

    @PostConstruct
    public void init() {
        this.genero = new Genero();
        this.generos = generoBean.findAll();
        this.generos.sort((a,b)-> a.getIdGenero().compareTo(b.getIdGenero()));
    }

    public Genero getGenero() {
        return genero;
    }

<<<<<<< HEAD
    public void setGenero(Genero genero) {
=======
    public void setGenero(Genero gemerp) {
>>>>>>> master
        this.genero = genero;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGenero(List<Genero> generos) {
        this.generos = generos;
    }

    public void adicionar() {
        generoBean.insert(genero);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }

}
