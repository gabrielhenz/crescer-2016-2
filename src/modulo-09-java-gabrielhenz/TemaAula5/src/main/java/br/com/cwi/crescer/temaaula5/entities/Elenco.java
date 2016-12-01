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
@Table(name = "ELENCO")
@NamedQueries({
    @NamedQuery(name = "Elenco.findAll", query = "SELECT E FROM ELENCO E")
})
public class Elenco implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_ELENCO")
    @SequenceGenerator(name = "SEQ_ELENCO", sequenceName = "SEQ_ELENCO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_ELENCO")
    private Long idElenco;

    @Basic(optional = false)
    @Column(name = "NM_ELENCO")
    private String nmElenco;

    @OneToMany(mappedBy="elencoFilme")
    private List<Filme> filmes;
    
    @OneToMany(mappedBy="elencoAtores")
    private List<Ator> atores;

    public Elenco() {
    }
    
    public Elenco(Long idElenco, String nmElenco){
        this.idElenco = idElenco;
        this.nmElenco = nmElenco;
    }
    
    public Long getIdElenco() {
        return idElenco;
    }

    public void setIdElenco(Long idElenco) {
        this.idElenco = idElenco;
    }

    public String getNmElenco() {
        return nmElenco;
    }

    public void setNmElenco(String nmElenco) {
        this.nmElenco = nmElenco;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }
    
    
}