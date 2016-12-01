/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.temaaula5.managedbeans;

import br.com.cwi.crescer.temaaula5.beans.AtorBean;
import br.com.cwi.crescer.temaaula5.beans.ElencoBean;
import br.com.cwi.crescer.temaaula5.beans.IdiomaBean;
import br.com.cwi.crescer.temaaula5.entities.Ator;
import br.com.cwi.crescer.temaaula5.entities.Elenco;
import br.com.cwi.crescer.temaaula5.entities.Idioma;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author alunoinfo
 */
@ManagedBean
@ViewScoped
public class ElencoManager {

    @EJB
    private AtorBean atorBean;
    
    @EJB
    private ElencoBean elencoBean;
    
    private Elenco elenco;
    private List<Elenco> elencos;
    private List<String> idAtores;

    @PostConstruct
    public void init() {
        this.elenco = new Elenco();
        this.elencos = elencoBean.findAll();
        this.elencos.sort((a,b)-> a.getIdElenco().compareTo(b.getIdElenco()));
    }

    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    public List<Elenco> getElencos() {
        return elencos;
    }

    public void setElenco(List<Elenco> elencos) {
        this.elencos = elencos;
    }

    public List<String> getIdAtores() {
        return idAtores;
    }

    public void setIdAtores(List<String> idAtores) {
        this.idAtores = idAtores;
    }

    
    
    public void adicionar() {
        List<Ator> atores = new ArrayList<>();
        this.idAtores.forEach(id -> {
            atores.add(this.atorBean.find(Long.parseLong(id)));
        });
        if(atores.size() > 0){
            elenco.setAtores(atores);
        }
        elencoBean.insert(elenco);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }
    

}
