/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(catalog = "auto_escola", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p")
    , @NamedQuery(name = "Professor.findById", query = "SELECT p FROM Professor p WHERE p.id = :id")
    , @NamedQuery(name = "Professor.findByNome", query = "SELECT p FROM Professor p WHERE p.nome = :nome")
    , @NamedQuery(name = "Professor.findByEmail", query = "SELECT p FROM Professor p WHERE p.email = :email")})
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String nome;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professorId")
    private List<AulaTeorica> aulaTeoricaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professorId")
    private List<AulaPratica> aulaPraticaList;
    @JoinColumn(name = "login_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Login loginId;

    public Professor() {
    }

    public Professor(Integer id) {
        this.id = id;
    }

    public Professor(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<AulaTeorica> getAulaTeoricaList() {
        return aulaTeoricaList;
    }

    public void setAulaTeoricaList(List<AulaTeorica> aulaTeoricaList) {
        this.aulaTeoricaList = aulaTeoricaList;
    }

    @XmlTransient
    public List<AulaPratica> getAulaPraticaList() {
        return aulaPraticaList;
    }

    public void setAulaPraticaList(List<AulaPratica> aulaPraticaList) {
        this.aulaPraticaList = aulaPraticaList;
    }

    public Login getLoginId() {
        return loginId;
    }

    public void setLoginId(Login loginId) {
        this.loginId = loginId;
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
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Professor[ id=" + id + " ]";
    }
    
}
