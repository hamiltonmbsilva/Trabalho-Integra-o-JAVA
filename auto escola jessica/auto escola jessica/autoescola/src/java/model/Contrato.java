/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jessica
 */
@Entity
@Table(catalog = "cfc", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c"),
    @NamedQuery(name = "Contrato.findById", query = "SELECT c FROM Contrato c WHERE c.id = :id"),
    @NamedQuery(name = "Contrato.findByValidade", query = "SELECT c FROM Contrato c WHERE c.validade = :validade")})
public class Contrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date validade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contratoId")
    private List<Recebimento> recebimentoList;
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Pessoa pessoaId;
    @JoinColumn(name = "plano_pagamento_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private PlanoPagamento planoPagamentoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contratoId")
    private List<ContratoHasTipoAula> contratoHasTipoAulaList;

    public Contrato() {
    }

    public Contrato(Integer id) {
        this.id = id;
    }

    public Contrato(Integer id, Date validade) {
        this.id = id;
        this.validade = validade;
    }
    public Contrato(Date validade,Pessoa pessoaId,PlanoPagamento planoPagamentoId ) {
        this.validade = validade;
        this.planoPagamentoId =  planoPagamentoId;
        this.pessoaId = pessoaId;
    }
    public Contrato(int id,Date validade,Pessoa pessoaId,PlanoPagamento planoPagamentoId ) {
        this.id = id;
        this.validade = validade;
        this.planoPagamentoId =  planoPagamentoId;
        this.pessoaId = pessoaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    @XmlTransient
    public List<Recebimento> getRecebimentoList() {
        return recebimentoList;
    }

    public void setRecebimentoList(List<Recebimento> recebimentoList) {
        this.recebimentoList = recebimentoList;
    }

    public Pessoa getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Pessoa pessoaId) {
        this.pessoaId = pessoaId;
    }

    public PlanoPagamento getPlanoPagamentoId() {
        return planoPagamentoId;
    }

    public void setPlanoPagamentoId(PlanoPagamento planoPagamentoId) {
        this.planoPagamentoId = planoPagamentoId;
    }

    @XmlTransient
    public List<ContratoHasTipoAula> getContratoHasTipoAulaList() {
        return contratoHasTipoAulaList;
    }

    public void setContratoHasTipoAulaList(List<ContratoHasTipoAula> contratoHasTipoAulaList) {
        this.contratoHasTipoAulaList = contratoHasTipoAulaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrato)) {
            return false;
        }
        Contrato other = (Contrato) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Contrato[ id=" + id + " ]";
    }
    
}
