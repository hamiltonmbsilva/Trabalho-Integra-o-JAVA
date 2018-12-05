/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jessica
 */
@Entity
@Table(name = "contrato_has_tipo_aula", catalog = "cfc", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContratoHasTipoAula.findAll", query = "SELECT c FROM ContratoHasTipoAula c"),
    @NamedQuery(name = "ContratoHasTipoAula.findById", query = "SELECT c FROM ContratoHasTipoAula c WHERE c.id = :id")})
public class ContratoHasTipoAula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @JoinColumn(name = "contrato_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Contrato contratoId;
    @JoinColumn(name = "tipo_aula_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TipoAula tipoAulaId;

    public ContratoHasTipoAula() {
    }

    public ContratoHasTipoAula(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contrato getContratoId() {
        return contratoId;
    }

    public void setContratoId(Contrato contratoId) {
        this.contratoId = contratoId;
    }

    public TipoAula getTipoAulaId() {
        return tipoAulaId;
    }

    public void setTipoAulaId(TipoAula tipoAulaId) {
        this.tipoAulaId = tipoAulaId;
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
        if (!(object instanceof ContratoHasTipoAula)) {
            return false;
        }
        ContratoHasTipoAula other = (ContratoHasTipoAula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ContratoHasTipoAula[ id=" + id + " ]";
    }
    
}
