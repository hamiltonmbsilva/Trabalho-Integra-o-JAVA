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
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matricula.findById", query = "SELECT m FROM Matricula m WHERE m.id = :id"),
    @NamedQuery(name = "Matricula.findByPreMatricula", query = "SELECT m FROM Matricula m WHERE m.preMatricula = :preMatricula"),
    @NamedQuery(name = "Matricula.findByPsicotecnico", query = "SELECT m FROM Matricula m WHERE m.psicotecnico = :psicotecnico"),
    @NamedQuery(name = "Matricula.findByLogin", query = "SELECT m FROM Matricula m WHERE m.login = :login"),
    @NamedQuery(name = "Matricula.findBySenha", query = "SELECT m FROM Matricula m WHERE m.senha = :senha"),
    @NamedQuery(name = "Matricula.findByEmail", query = "SELECT m FROM Matricula m WHERE m.email = :email")})
public class Matricula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "pre_matricula")
    private Boolean preMatricula;
    @Column(length = 9)
    private Boolean psicotecnico;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String login;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String senha;
    @Basic(optional = false)
    @Column(nullable = false, length = 200)
    private String email;
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Pessoa pessoaId;

    public Matricula() {
    }

    public Matricula(Integer id) {
        this.id = id;
    }

    public Matricula(Integer id, String login, String senha, String email) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }
    
    public Matricula(String login, String senha, String email,Pessoa PessoaId,boolean preMatricula, Boolean psicotecnico) {
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.pessoaId = PessoaId;
        this.preMatricula = preMatricula;
        this.psicotecnico = psicotecnico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getPreMatricula() {
        return preMatricula;
    }

    public void setPreMatricula(Boolean preMatricula) {
        this.preMatricula = preMatricula;
    }

    public Boolean getPsicotecnico() {
        return psicotecnico;
    }

    public void setPsicotecnico(Boolean psicotecnico) {
        this.psicotecnico = psicotecnico;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pessoa getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Pessoa pessoaId) {
        this.pessoaId = pessoaId;
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
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Matricula[ id=" + id + " ]";
    }
    
}
