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
import javax.persistence.JoinColumn;
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
@Table(name = "ATOR")
//@NamedQueries({
//    @NamedQuery(name = "Ator.findAll", query = "SELECT A FROM ATOR A")
//})
public class Ator implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_ATOR")
    @SequenceGenerator(name = "SEQ_ATOR", sequenceName = "SEQ_ATOR", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_ATOR")
    private Long idAtor;

    @Basic(optional = false)
    @Column(name = "NM_ATOR")
    private String nmAtor;

    @ManyToOne
    @JoinColumn(name = "ID_ELENCO_ATOR")
    private Elenco elencoAtor;

    public Ator() {
    }

    public Ator(Long idAtor, String nmAtor){
        this.idAtor = idAtor;
        this.nmAtor = nmAtor;
    }
    
    public Long getIdAtor() {
        return idAtor;
    }

    public void setIdAtor(Long idAtor) {
        this.idAtor = idAtor;
    }

    public String getNmAtor() {
        return nmAtor;
    }

    public void setNmAtor(String nmAtor) {
        this.nmAtor = nmAtor;
    }

    public Elenco getElencoAtor() {
        return elencoAtor;
    }

    public void setElencoAtor(Elenco elencoAtor) {
        this.elencoAtor = elencoAtor;
    }
    
    
}

