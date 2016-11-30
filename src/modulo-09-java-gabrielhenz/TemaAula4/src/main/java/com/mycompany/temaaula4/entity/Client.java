/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.temaaula4.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author gabriel.henz
 */
@Entity
@Table(name = "CLIENT")
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByIdClient", query = "SELECT c FROM Client c WHERE c.idClient = :idClient"),
    @NamedQuery(name = "Client.findByDsEmail", query = "SELECT c FROM Client c WHERE c.dsEmail = :dsEmail"),
    @NamedQuery(name = "Client.findByDsPassword", query = "SELECT c FROM Client c WHERE c.dsPassword = :dsPassword"),
    @NamedQuery(name = "Client.findByDsPreferredCoin", query = "SELECT c FROM Client c WHERE c.dsPreferredCoin = :dsPreferredCoin"),
    @NamedQuery(name = "Client.findByDsState", query = "SELECT c FROM Client c WHERE c.dsState = :dsState"),
    @NamedQuery(name = "Client.findByDsUserName", query = "SELECT c FROM Client c WHERE c.dsUserName = :dsUserName"),
    @NamedQuery(name = "Client.findByNmClient", query = "SELECT c FROM Client c WHERE c.nmClient = :nmClient"),
    @NamedQuery(name = "Client.findByTpPermission", query = "SELECT c FROM Client c WHERE c.tpPermission = :tpPermission")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CLIENT")
    @SequenceGenerator(name = "SEQ_CLIENT", sequenceName = "SEQ_CLIENT")
    @Basic(optional = false)
    @Column(name = "ID_CLIENT")
    private Long idClient;
    @Basic(optional = false)
    @Column(name = "DS_EMAIL")
    private String dsEmail;
    @Basic(optional = false)
    @Column(name = "DS_PASSWORD")
    private String dsPassword;
    @Basic(optional = false)
    @Column(name = "DS_PREFERRED_COIN")
    private String dsPreferredCoin;
    @Basic(optional = false)
    @Column(name = "DS_STATE")
    private String dsState;
    @Basic(optional = false)
    @Column(name = "DS_USER_NAME")
    private String dsUserName;
    @Basic(optional = false)
    @Column(name = "NM_CLIENT")
    private String nmClient;
    @Basic(optional = false)
    @Column(name = "TP_PERMISSION")
    private String tpPermission;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientIdClient")
    private List<Contract> contractList;

    public Client() {
    }

    public Client(Long idClient) {
        this.idClient = idClient;
    }

    public Client(Long idClient, String dsEmail, String dsPassword, String dsPreferredCoin, String dsState, String dsUserName, String nmClient, String tpPermission) {
        this.idClient = idClient;
        this.dsEmail = dsEmail;
        this.dsPassword = dsPassword;
        this.dsPreferredCoin = dsPreferredCoin;
        this.dsState = dsState;
        this.dsUserName = dsUserName;
        this.nmClient = nmClient;
        this.tpPermission = tpPermission;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getDsPassword() {
        return dsPassword;
    }

    public void setDsPassword(String dsPassword) {
        this.dsPassword = dsPassword;
    }

    public String getDsPreferredCoin() {
        return dsPreferredCoin;
    }

    public void setDsPreferredCoin(String dsPreferredCoin) {
        this.dsPreferredCoin = dsPreferredCoin;
    }

    public String getDsState() {
        return dsState;
    }

    public void setDsState(String dsState) {
        this.dsState = dsState;
    }

    public String getDsUserName() {
        return dsUserName;
    }

    public void setDsUserName(String dsUserName) {
        this.dsUserName = dsUserName;
    }

    public String getNmClient() {
        return nmClient;
    }

    public void setNmClient(String nmClient) {
        this.nmClient = nmClient;
    }

    public String getTpPermission() {
        return tpPermission;
    }

    public void setTpPermission(String tpPermission) {
        this.tpPermission = tpPermission;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(
            "ID:%d; Email:%s; Senha:%s; Moeda preferida:%s; Estado:%s; Nome de usuario:%s; Nome do cliente:%s; Permissão:%s;",
            this.idClient, 
            this.dsEmail, 
            this.dsPassword, 
            this.dsPreferredCoin, 
            this.dsState, 
            this.dsUserName, 
            this.nmClient, 
            this.tpPermission
        );
    }
    
}
