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
import javax.persistence.ManyToOne;
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
@Table(name = "GENERO")
//@NamedQueries({
//    @NamedQuery(name = "Genero.findAll", query = "SELECT G FROM GENERO G")
//})
public class Genero implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_GENERO")
    @SequenceGenerator(name = "SEQ_GENERO", sequenceName = "SEQ_GENERO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_GENERO")
    private Long idGenero;

    @Basic(optional = false)
    @Column(name = "NM_GENERO")
    private String nmGenero;

    @OneToMany(mappedBy="genero")
    private List<Filme> filmes;

    public Genero() {
    }

    public Genero(Long idGenero, String nmGenero){
        this.idGenero = idGenero;
        this.nmGenero = nmGenero;
    }
    
    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public String getNmGenero() {
        return nmGenero;
    }

    public void setNmGenero(String nmGenero) {
        this.nmGenero = nmGenero;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }
    
    
}

