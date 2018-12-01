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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * @author Administrador
 */
@Entity
@Table(catalog = "auto_escola", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a")
    , @NamedQuery(name = "Aluno.findByMatricula", query = "SELECT a FROM Aluno a WHERE a.matricula = :matricula")
    , @NamedQuery(name = "Aluno.findByNome", query = "SELECT a FROM Aluno a WHERE a.nome = :nome")
    , @NamedQuery(name = "Aluno.findByEmail", query = "SELECT a FROM Aluno a WHERE a.email = :email")
    , @NamedQuery(name = "Aluno.findByLogradouro", query = "SELECT a FROM Aluno a WHERE a.logradouro = :logradouro")
    , @NamedQuery(name = "Aluno.findByBairro", query = "SELECT a FROM Aluno a WHERE a.bairro = :bairro")
    , @NamedQuery(name = "Aluno.findByNumero", query = "SELECT a FROM Aluno a WHERE a.numero = :numero")
    , @NamedQuery(name = "Aluno.findByComplemento", query = "SELECT a FROM Aluno a WHERE a.complemento = :complemento")
    , @NamedQuery(name = "Aluno.findByCidade", query = "SELECT a FROM Aluno a WHERE a.cidade = :cidade")
    , @NamedQuery(name = "Aluno.findByEstado", query = "SELECT a FROM Aluno a WHERE a.estado = :estado")
    , @NamedQuery(name = "Aluno.findByMatriculado", query = "SELECT a FROM Aluno a WHERE a.matriculado = :matriculado")
    , @NamedQuery(name = "Aluno.findByDataNascimento", query = "SELECT a FROM Aluno a WHERE a.dataNascimento = :dataNascimento")
    , @NamedQuery(name = "Aluno.findByCpf", query = "SELECT a FROM Aluno a WHERE a.cpf = :cpf")})
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer matricula;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String nome;
    @Basic(optional = false)
    @Column(nullable = false, length = 30)
    private String email;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String logradouro;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String bairro;
    @Basic(optional = false)
    @Column(nullable = false, length = 10)
    private String numero;
    @Column(length = 30)
    private String complemento;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String cidade;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String estado;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean matriculado;
    @Basic(optional = false)
    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Basic(optional = false)
    @Column(nullable = false, length = 11)
    private String cpf;
    @JoinTable(name = "aula_teorica_has_aluno", joinColumns = {
        @JoinColumn(name = "aluno_matricula", referencedColumnName = "matricula", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "aula_teorica_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<AulaTeorica> aulaTeoricaList;
    @JoinColumn(name = "login_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Login loginId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alunoMatricula")
    private List<AulaPratica> aulaPraticaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alunoMatricula")
    private List<Pagamento> pagamentoList;

    public Aluno() {
    }

    public Aluno(Integer matricula) {
        this.matricula = matricula;
    }

    public Aluno(Integer matricula, String nome, String email, String logradouro, String bairro, String numero, String cidade, String estado, boolean matriculado, Date dataNascimento, String cpf) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.matriculado = matriculado;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }
    
    public String dataNascimentoToString(){
        return new SimpleDateFormat("dd/MM/yyyy").format(dataNascimento);
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean getMatriculado() {
        return matriculado;
    }

    public void setMatriculado(boolean matriculado) {
        this.matriculado = matriculado;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @XmlTransient
    public List<AulaTeorica> getAulaTeoricaList() {
        return aulaTeoricaList;
    }

    public void setAulaTeoricaList(List<AulaTeorica> aulaTeoricaList) {
        this.aulaTeoricaList = aulaTeoricaList;
    }

    public Login getLoginId() {
        return loginId;
    }

    public void setLoginId(Login loginId) {
        this.loginId = loginId;
    }

    @XmlTransient
    public List<AulaPratica> getAulaPraticaList() {
        return aulaPraticaList;
    }

    public void setAulaPraticaList(List<AulaPratica> aulaPraticaList) {
        this.aulaPraticaList = aulaPraticaList;
    }

    @XmlTransient
    public List<Pagamento> getPagamentoList() {
        return pagamentoList;
    }

    public void setPagamentoList(List<Pagamento> pagamentoList) {
        this.pagamentoList = pagamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricula != null ? matricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Aluno[ matricula=" + matricula + " ]";
    }
    
}
