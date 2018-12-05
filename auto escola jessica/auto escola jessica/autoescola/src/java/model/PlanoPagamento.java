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
@Table(name = "plano_pagamento", catalog = "cfc", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanoPagamento.findAll", query = "SELECT p FROM PlanoPagamento p"),
    @NamedQuery(name = "PlanoPagamento.findById", query = "SELECT p FROM PlanoPagamento p WHERE p.id = :id"),
    @NamedQuery(name = "PlanoPagamento.findByQdtParcelas", query = "SELECT p FROM PlanoPagamento p WHERE p.qdtParcelas = :qdtParcelas"),
    @NamedQuery(name = "PlanoPagamento.findByValorTotal", query = "SELECT p FROM PlanoPagamento p WHERE p.valorTotal = :valorTotal"),
    @NamedQuery(name = "PlanoPagamento.findByNome", query = "SELECT p FROM PlanoPagamento p WHERE p.nome = :nome"),
    @NamedQuery(name = "PlanoPagamento.findByVencimento", query = "SELECT p FROM PlanoPagamento p WHERE p.vencimento = :vencimento")})
public class PlanoPagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "qdt_parcelas", nullable = false)
    private int qdtParcelas;
    @Basic(optional = false)
    @Column(name = "valor_total", nullable = false)
    private double valorTotal;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nome;
    @Basic(optional = false)
    @Column(nullable = false)
    private String vencimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planoPagamentoId")
    private List<Contrato> contratoList;

    public PlanoPagamento() {
    }

    public PlanoPagamento(Integer id) {
        this.id = id;
    }

    public PlanoPagamento(int qdtParcelas, double valorTotal, String nome, String vencimento) {
        this.qdtParcelas = qdtParcelas;
        this.valorTotal = valorTotal;
        this.nome = nome;
        this.vencimento = vencimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQdtParcelas() {
        return qdtParcelas;
    }

    public void setQdtParcelas(int qdtParcelas) {
        this.qdtParcelas = qdtParcelas;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    @XmlTransient
    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
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
        if (!(object instanceof PlanoPagamento)) {
            return false;
        }
        PlanoPagamento other = (PlanoPagamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PlanoPagamento[ id=" + id + " ]";
    }
    
}
