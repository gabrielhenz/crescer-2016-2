/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.temaaula5.managedbeans;

<<<<<<< HEAD
import br.com.cwi.crescer.temaaula5.beans.ClassificacaoBean;
import br.com.cwi.crescer.temaaula5.beans.ElencoBean;
import br.com.cwi.crescer.temaaula5.beans.FilmeBean;
import br.com.cwi.crescer.temaaula5.beans.GeneroBean;
import br.com.cwi.crescer.temaaula5.beans.IdiomaBean;
import br.com.cwi.crescer.temaaula5.entities.Classificacao;
import br.com.cwi.crescer.temaaula5.entities.Elenco;
import br.com.cwi.crescer.temaaula5.entities.Filme;
import br.com.cwi.crescer.temaaula5.entities.Genero;
import br.com.cwi.crescer.temaaula5.entities.Idioma;
=======
import br.com.cwi.crescer.temaaula5.beans.FilmeBean;
import br.com.cwi.crescer.temaaula5.entities.Filme;
>>>>>>> master
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
public class FilmeManager {

    @EJB
    private FilmeBean filmeBean;
<<<<<<< HEAD

    @EJB
    private GeneroBean generoBean;

    @EJB
    private ElencoBean elencoBean;

    @EJB
    private ClassificacaoBean classificacaoBean;

    @EJB
    private IdiomaBean idiomaBean;

    private Filme filme;
    private List<Filme> filmes;
    private String idGenero;
    private String idIdioma;
    private String idElenco;
    private String idClassificacao;
=======
    
    private Filme filme;
    private List<Filme> filmes;
>>>>>>> master

    @PostConstruct
    public void init() {
        this.filme = new Filme();
        this.filmes = filmeBean.findAll();
<<<<<<< HEAD
        this.filmes.sort((a, b) -> a.getIdFilme().compareTo(b.getIdFilme()));
=======
        this.filmes.sort((a,b)-> a.getIdFilme().compareTo(b.getIdFilme()));
>>>>>>> master
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

<<<<<<< HEAD
    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public String getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(String idGenero) {
        this.idGenero = idGenero;
    }

    public String getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(String idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getIdElenco() {
        return idElenco;
    }

    public void setIdElenco(String idElenco) {
        this.idElenco = idElenco;
    }

    public String getIdClassificacao() {
        return idClassificacao;
    }

    public void setIdClassificacao(String idClassificacao) {
        this.idClassificacao = idClassificacao;
    }

    

    public void adicionar() {
        if (filme.getDsTitulo().isEmpty() || filme.getDsTitulo() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Preencha o nome", "Preencha o nome"));
        } else {
            filmeBean.insert(filme);
        }
        this.init();
    }

}
=======
    public void setPessoas(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public void adicionar() {
        filmeBean.insert(filme);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }

}
>>>>>>> master
