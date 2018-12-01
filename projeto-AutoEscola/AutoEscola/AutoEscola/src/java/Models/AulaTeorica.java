/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "aula_teorica", catalog = "auto_escola", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AulaTeorica.findAll", query = "SELECT a FROM AulaTeorica a")
    , @NamedQuery(name = "AulaTeorica.findById", query = "SELECT a FROM AulaTeorica a WHERE a.id = :id")
    , @NamedQuery(name = "AulaTeorica.findByDataAula", query = "SELECT a FROM AulaTeorica a WHERE a.dataAula = :dataAula")
    , @NamedQuery(name = "AulaTeorica.findByTema", query = "SELECT a FROM AulaTeorica a WHERE a.tema = :tema")})
public class AulaTeorica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "data_aula", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAula;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String tema;
    @ManyToMany(mappedBy = "aulaTeoricaList")
    private List<Aluno> alunoList;
    @JoinColumn(name = "professor_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Professor professorId;

    public AulaTeorica() {
    }

    public AulaTeorica(Integer id) {
        this.id = id;
    }

    public AulaTeorica(Integer id, Date dataAula, String tema) {
        this.id = id;
        this.dataAula = dataAula;
        this.tema = tema;
    }
    
    public String dataAulaToString(){
        return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(dataAula);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataAula() {
        return dataAula;
    }

    public void setDataAula(Date dataAula) {
        this.dataAula = dataAula;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @XmlTransient
    public List<Aluno> getAlunoList() {
        return alunoList;
    }

    public void setAlunoList(List<Aluno> alunoList) {
        this.alunoList = alunoList;
    }

    public Professor getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Professor professorId) {
        this.professorId = professorId;
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
        if (!(object instanceof AulaTeorica)) {
            return false;
        }
        AulaTeorica other = (AulaTeorica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.AulaTeorica[ id=" + id + " ]";
    }
    
}
