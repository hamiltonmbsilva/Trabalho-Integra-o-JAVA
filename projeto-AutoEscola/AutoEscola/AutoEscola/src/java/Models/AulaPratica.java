/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
@Table(name = "aula_pratica", catalog = "auto_escola", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AulaPratica.findAll", query = "SELECT a FROM AulaPratica a")
    , @NamedQuery(name = "AulaPratica.findById", query = "SELECT a FROM AulaPratica a WHERE a.id = :id")
    , @NamedQuery(name = "AulaPratica.findByDataAula", query = "SELECT a FROM AulaPratica a WHERE a.dataAula = :dataAula")
    , @NamedQuery(name = "AulaPratica.findByTema", query = "SELECT a FROM AulaPratica a WHERE a.tema = :tema")
    , @NamedQuery(name = "AulaPratica.findByVeiculo", query = "SELECT a FROM AulaPratica a WHERE a.veiculo = :veiculo")})
public class AulaPratica implements Serializable {

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
    @Basic(optional = false)
    @Column(nullable = false, length = 12)
    private String veiculo;
    @JoinColumn(name = "aluno_matricula", referencedColumnName = "matricula", nullable = false)
    @ManyToOne(optional = false)
    private Aluno alunoMatricula;
    @JoinColumn(name = "professor_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Professor professorId;

    public AulaPratica() {
    }

    public AulaPratica(Integer id) {
        this.id = id;
    }

    public AulaPratica(Integer id, Date dataAula, String tema, String veiculo) {
        this.id = id;
        this.dataAula = dataAula;
        this.tema = tema;
        this.veiculo = veiculo;
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

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public Aluno getAlunoMatricula() {
        return alunoMatricula;
    }

    public void setAlunoMatricula(Aluno alunoMatricula) {
        this.alunoMatricula = alunoMatricula;
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
        if (!(object instanceof AulaPratica)) {
            return false;
        }
        AulaPratica other = (AulaPratica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.AulaPratica[ id=" + id + " ]";
    }
    
}
