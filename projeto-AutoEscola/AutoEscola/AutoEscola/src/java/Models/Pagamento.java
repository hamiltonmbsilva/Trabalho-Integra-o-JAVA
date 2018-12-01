/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(catalog = "auto_escola", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagamento.findAll", query = "SELECT p FROM Pagamento p")
    , @NamedQuery(name = "Pagamento.findById", query = "SELECT p FROM Pagamento p WHERE p.id = :id")
    , @NamedQuery(name = "Pagamento.findBySituacao", query = "SELECT p FROM Pagamento p WHERE p.situacao = :situacao")
    , @NamedQuery(name = "Pagamento.findByAvista", query = "SELECT p FROM Pagamento p WHERE p.avista = :avista")
    , @NamedQuery(name = "Pagamento.findByValor", query = "SELECT p FROM Pagamento p WHERE p.valor = :valor")
    , @NamedQuery(name = "Pagamento.findByNumParcelas", query = "SELECT p FROM Pagamento p WHERE p.numParcelas = :numParcelas")
    , @NamedQuery(name = "Pagamento.findByValorParcelas", query = "SELECT p FROM Pagamento p WHERE p.valorParcelas = :valorParcelas")
    , @NamedQuery(name = "Pagamento.findByDataPagamento", query = "SELECT p FROM Pagamento p WHERE p.dataPagamento = :dataPagamento")
    , @NamedQuery(name = "Pagamento.findByQtdAulaPratica", query = "SELECT p FROM Pagamento p WHERE p.qtdAulaPratica = :qtdAulaPratica")
    , @NamedQuery(name = "Pagamento.findByQtdAulaTeorica", query = "SELECT p FROM Pagamento p WHERE p.qtdAulaTeorica = :qtdAulaTeorica")})
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 15)
    private String situacao;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean avista;
    @Basic(optional = false)
    @Column(nullable = false)
    private Double valor;
    @Column(name = "num_parcelas")
    private Integer numParcelas;
    @Column(name = "valor_parcelas")
    private Double valorParcelas;
    @Basic(optional = false)
    @Column(name = "data_pagamento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    @Basic(optional = false)
    @Column(name = "qtd_aula_pratica", nullable = false)
    private int qtdAulaPratica;
    @Basic(optional = false)
    @Column(name = "qtd_aula_teorica", nullable = false)
    private int qtdAulaTeorica;
    @JoinColumn(name = "aluno_matricula", referencedColumnName = "matricula", nullable = false)
    @ManyToOne(optional = false)
    private Aluno alunoMatricula;

    public Pagamento() {
    }

    public Pagamento(Integer id) {
        this.id = id;
    }

    public Pagamento(Integer id, String situacao, boolean avista, Double valor, Date dataPagamento, int qtdAulaPratica, int qtdAulaTeorica) {
        this.id = id;
        this.situacao = situacao;
        this.avista = avista;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.qtdAulaPratica = qtdAulaPratica;
        this.qtdAulaTeorica = qtdAulaTeorica;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public boolean getAvista() {
        return avista;
    }

    public void setAvista(boolean avista) {
        this.avista = avista;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(Integer numParcelas) {
        this.numParcelas = numParcelas;
    }

    public Double getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(Double valorParcelas) {
        this.valorParcelas = valorParcelas;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public int getQtdAulaPratica() {
        return qtdAulaPratica;
    }

    public void setQtdAulaPratica(int qtdAulaPratica) {
        this.qtdAulaPratica = qtdAulaPratica;
    }

    public int getQtdAulaTeorica() {
        return qtdAulaTeorica;
    }

    public void setQtdAulaTeorica(int qtdAulaTeorica) {
        this.qtdAulaTeorica = qtdAulaTeorica;
    }

    public Aluno getAlunoMatricula() {
        return alunoMatricula;
    }

    public void setAlunoMatricula(Aluno alunoMatricula) {
        this.alunoMatricula = alunoMatricula;
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
        if (!(object instanceof Pagamento)) {
            return false;
        }
        Pagamento other = (Pagamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Pagamento[ id=" + id + " ]";
    }
    
}
