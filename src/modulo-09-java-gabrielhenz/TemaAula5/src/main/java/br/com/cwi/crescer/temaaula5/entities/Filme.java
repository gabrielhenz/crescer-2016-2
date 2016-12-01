/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.temaaula5.entities;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gabriel.henz
 */


@Entity
@Table(name = "FILME")
//@NamedQueries({
//    @NamedQuery(name = "Filme.findAll", query = "SELECT F FROM FILME F")
//})
public class Filme implements Serializable{
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_FILME")
    @SequenceGenerator(name = "SEQ_FILME", sequenceName = "SEQ_FILME", allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "ID_FILME")
    private Long idFilme;

    @Basic(optional = false)
    @Column(name = "DS_TITULO")
    private String dsTitulo;
    
    @Basic(optional = false)
    @Column(name = "DS_DIRETOR")
    private String dsDiretor;
    
    @Column(name = "DT_LANCAMENTO", nullable = true)
    @Temporal(TemporalType.DATE)
    @Basic(optional = true)
    private Date dtLancamento;

    @ManyToOne
    @JoinColumn(name = "ID_GENERO")
    private Genero genero;
    
    @ManyToOne
    @JoinColumn(name = "ID_ELENCO_FILME")
    private Elenco elencoFilme;
    
    @ManyToOne
    @JoinColumn(name = "ID_IDIOMA")
    private Idioma idioma;
    
    @ManyToOne
    @JoinColumn(name = "ID_CLASSIFICACAO")
    private Classificacao classificacao;

    public Filme() {
    }

    public Filme(Long idFilme, String dsTitulo, String dsDiretor, Date dtLancamento, 
            Genero genero, Elenco elencoFilme, Idioma idioma, Classificacao classificacao){
        this.idFilme = idFilme;
        this.dsTitulo = dsTitulo;
        this.dsDiretor = dsDiretor;
        this.dtLancamento = dtLancamento;
        this.genero = genero;
        this.elencoFilme = elencoFilme;
        this.idioma = idioma;
        this.classificacao = classificacao;
    }
    
    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public String getDsTitulo() {
        return dsTitulo;
    }

    public void setDsTitulo(String dsTitulo) {
        this.dsTitulo = dsTitulo;
    }
    
    public String getDsDiretor() {
        return dsDiretor;
    }

    public void setDsDiretor(String dsDiretor) {
        this.dsDiretor = dsDiretor;
    }

    public Date getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(Date dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Elenco getElencoFilme() {
        return elencoFilme;
    }

    public void setElencoFilme(Elenco elencoFilme) {
        this.elencoFilme = elencoFilme;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }
    
    
}
