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
@Table(catalog = "cfc", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a"),
    @NamedQuery(name = "Agenda.findById", query = "SELECT a FROM Agenda a WHERE a.id = :id"),
    @NamedQuery(name = "Agenda.findByDisponivel", query = "SELECT a FROM Agenda a WHERE a.disponivel = :disponivel")})
public class Agenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean disponivel;
    @JoinColumn(name = "aula_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Aula aulaId;
    @JoinColumn(name = "aluno_id", referencedColumnName = "id")
    @ManyToOne
    private Pessoa alunoId;
    @JoinColumn(name = "professor_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Pessoa professorId;

    public Agenda() {
    }

    public Agenda(Integer id) {
        this.id = id;
    }

    public Agenda(Integer id, boolean disponivel) {
        this.id = id;
        this.disponivel = disponivel;
    }
    public Agenda(boolean disponivel,Aula aulaId,Pessoa professorId) {
        this.disponivel = disponivel;
        this.aulaId = aulaId;
        this.professorId = professorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Aula getAulaId() {
        return aulaId;
    }

    public void setAulaId(Aula aulaId) {
        this.aulaId = aulaId;
    }

    public Pessoa getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Pessoa alunoId) {
        this.alunoId = alunoId;
    }

    public Pessoa getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Pessoa professorId) {
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
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Agenda[ id=" + id + " ]";
    }
    
}
