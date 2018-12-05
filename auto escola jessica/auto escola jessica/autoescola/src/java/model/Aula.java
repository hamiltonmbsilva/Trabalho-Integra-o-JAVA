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
    @NamedQuery(name = "Aula.findAll", query = "SELECT a FROM Aula a"),
    @NamedQuery(name = "Aula.findById", query = "SELECT a FROM Aula a WHERE a.id = :id"),
    @NamedQuery(name = "Aula.findByData", query = "SELECT a FROM Aula a WHERE a.data = :data"),
    @NamedQuery(name = "Aula.findByHora", query = "SELECT a FROM Aula a WHERE a.hora = :hora")})
public class Aula implements Serializable {
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
    @Basic(optional = false)
    @Column(nullable = false, length = 5)
    private String hora;
    @JoinColumn(name = "tipo_aula_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TipoAula tipoAulaId;
    @JoinColumn(name = "veiculo_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Veiculo veiculoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aulaId")
    private List<Agenda> agendaList;

    public Aula() {
    }

    public Aula(Integer id) {
        this.id = id;
    }

    public Aula(Integer id, Date data, String hora) {
        this.id = id;
        this.data = data;
        this.hora = hora;
    }
    
    public Aula(Date data, String hora,TipoAula tipoAulaId,Veiculo veiculoId) {
        this.data = data;
        this.hora = hora;
        this.tipoAulaId = tipoAulaId;
        this.veiculoId = veiculoId;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public TipoAula getTipoAulaId() {
        return tipoAulaId;
    }

    public void setTipoAulaId(TipoAula tipoAulaId) {
        this.tipoAulaId = tipoAulaId;
    }

    public Veiculo getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Veiculo veiculoId) {
        this.veiculoId = veiculoId;
    }

    @XmlTransient
    public List<Agenda> getAgendaList() {
        return agendaList;
    }

    public void setAgendaList(List<Agenda> agendaList) {
        this.agendaList = agendaList;
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
        if (!(object instanceof Aula)) {
            return false;
        }
        Aula other = (Aula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Aula[ id=" + id + " ]";
    }
    
}
