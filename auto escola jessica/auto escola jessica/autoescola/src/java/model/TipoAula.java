/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jessica
 */
@Entity
@Table(name = "tipo_aula", catalog = "cfc", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAula.findAll", query = "SELECT t FROM TipoAula t"),
    @NamedQuery(name = "TipoAula.findById", query = "SELECT t FROM TipoAula t WHERE t.id = :id"),
    @NamedQuery(name = "TipoAula.findByNome", query = "SELECT t FROM TipoAula t WHERE t.nome = :nome"),
    @NamedQuery(name = "TipoAula.findByCargaMinima", query = "SELECT t FROM TipoAula t WHERE t.cargaMinima = :cargaMinima")})
public class TipoAula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nome;
    @Basic(optional = false)
    @Column(name = "carga_minima", nullable = false)
    private int cargaMinima;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAulaId")
    private List<Aula> aulaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAulaId")
    private List<ContratoHasTipoAula> contratoHasTipoAulaList;

    public TipoAula() {
    }

    public TipoAula(Integer id) {
        this.id = id;
    }

    public TipoAula(Integer id, String nome, int cargaMinima) {
        this.id = id;
        this.nome = nome;
        this.cargaMinima = cargaMinima;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaMinima() {
        return cargaMinima;
    }

    public void setCargaMinima(int cargaMinima) {
        this.cargaMinima = cargaMinima;
    }

    @XmlTransient
    public List<Aula> getAulaList() {
        return aulaList;
    }

    public void setAulaList(List<Aula> aulaList) {
        this.aulaList = aulaList;
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
        if (!(object instanceof TipoAula)) {
            return false;
        }
        TipoAula other = (TipoAula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TipoAula[ id=" + id + " ]";
    }
    
}
