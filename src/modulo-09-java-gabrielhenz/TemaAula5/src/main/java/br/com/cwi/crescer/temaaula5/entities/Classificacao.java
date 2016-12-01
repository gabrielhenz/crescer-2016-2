/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.temaaula5.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Gabriel
 */
@Entity
@Table(name = "CLASSIFICACAO")
<<<<<<< HEAD
//@NamedQueries({
//    @NamedQuery(name = "Classificacao.findAll", query = "SELECT C FROM CLASSIFICACAO C")
//})
=======
@NamedQueries({
    @NamedQuery(name = "Classificacao.findAll", query = "SELECT C FROM CLASSIFICACAO C")
})
>>>>>>> master
public class Classificacao implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CLASSIFICACAO")
    @SequenceGenerator(name = "SEQ_CLASSIFICACAO", sequenceName = "SEQ_CLASSIFICACAO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CLASSIFICACAO")
    private Long idClassificacao;

    @Basic(optional = false)
    @Column(name = "NM_CLASSIFICACAO")
    private String nmClassificacao;

    @Basic(optional = false)
    @Column(name = "VL_IDADE")
    private int vlIdade;
    
    @OneToMany(mappedBy="classificacao")
    private List<Filme> filmes;

    public Classificacao() {
    }
    
    public Classificacao(Long idClassificacao, String nmClassificacao, int vlIdade){
        this.idClassificacao = idClassificacao;
        this.nmClassificacao = nmClassificacao;
        this.vlIdade = vlIdade;
    }

    public Long getIdClassificacao() {
        return idClassificacao;
    }

    public void setIdClassificacao(Long idClassificacao) {
        this.idClassificacao = idClassificacao;
    }

    public String getNmClassificacao() {
        return nmClassificacao;
    }

    public void setNmClassificacao(String nmClassificacao) {
        this.nmClassificacao = nmClassificacao;
    }

    public int getVlIdade() {
        return vlIdade;
    }

    public void setVlIdade(int vlIdade) {
        this.vlIdade = vlIdade;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }
    
    
}

