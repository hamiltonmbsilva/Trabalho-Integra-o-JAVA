/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
 * @author Jessica
 */
@Entity
@Table(catalog = "cfc", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recebimento.findAll", query = "SELECT r FROM Recebimento r"),
    @NamedQuery(name = "Recebimento.findById", query = "SELECT r FROM Recebimento r WHERE r.id = :id"),
    @NamedQuery(name = "Recebimento.findByData", query = "SELECT r FROM Recebimento r WHERE r.data = :data")})
public class Recebimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "contrato_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Contrato contratoId;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean pago;
    @Basic(optional = false)
    @Column(nullable = false)
    private double valor;

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Recebimento() {
    }

    public Recebimento(Integer id) {
        this.id = id;
    }

    public Recebimento(Integer id, Date data) {
        this.id = id;
        this.data = data;
    }
    public Recebimento(Date data,Contrato contratoId,boolean pago,double valor) {
        this.data = data;
        this.contratoId = contratoId;
        this.pago = pago;
        this.valor = valor;
    }
    
    public Recebimento(Date data,Contrato contratoId,boolean pago) {
        this.data = data;
        this.contratoId = contratoId;
        this.pago = pago;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Contrato getContratoId() {
        return contratoId;
    }

    public void setContratoId(Contrato contratoId) {
        this.contratoId = contratoId;
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
        if (!(object instanceof Recebimento)) {
            return false;
        }
        Recebimento other = (Recebimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Recebimento[ id=" + id + " ]";
    }
    
}
