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
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findById", query = "SELECT p FROM Pessoa p WHERE p.id = :id"),
    @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pessoa.findByDtNascimento", query = "SELECT p FROM Pessoa p WHERE p.dtNascimento = :dtNascimento"),
    @NamedQuery(name = "Pessoa.findByCpf", query = "SELECT p FROM Pessoa p WHERE p.cpf = :cpf"),
    @NamedQuery(name = "Pessoa.findBySexo", query = "SELECT p FROM Pessoa p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Pessoa.findByAtiva", query = "SELECT p FROM Pessoa p WHERE p.ativa = :ativa")})
public class Pessoa implements Serializable {
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
    @Column(name = "dt_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;
    @Basic(optional = false)
    @Column(nullable = false, length = 14)
    private String cpf;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean sexo;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean ativa;
    @JoinColumn(name = "tipo_pessoa_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TipoPessoa tipoPessoaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaId")
    private List<Matricula> matriculaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaId")
    private List<Contrato> contratoList;
    @OneToMany(mappedBy = "alunoId")
    private List<Agenda> agendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professorId")
    private List<Agenda> agendaList1;

    public Pessoa() {
    }

    public Pessoa(Integer id) {
        this.id = id;
    }

    public Pessoa(String nome, Date dtNascimento, String cpf, boolean sexo, boolean ativa,TipoPessoa tipoPessoaId) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
        this.sexo = sexo;
        this.ativa = ativa;
        this.tipoPessoaId = tipoPessoaId;
    }
    
    public Pessoa(Integer id,String nome, Date dtNascimento, String cpf, boolean sexo, boolean ativa,TipoPessoa tipoPessoaId) {
        this.id = id;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
        this.sexo = sexo;
        this.ativa = ativa;
        this.tipoPessoaId = tipoPessoaId;
    }
    

    public Pessoa(int i, String marcos_Paulo_Gamarano, String marcos_gamaranogmailcom, String rua_Badi_Geara, String ipiranga, String string, String ipiranga0, String ipiranga1, boolean b, Date date, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean getSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public TipoPessoa getTipoPessoaId() {
        return tipoPessoaId;
    }

    public void setTipoPessoaId(TipoPessoa tipoPessoaId) {
        this.tipoPessoaId = tipoPessoaId;
    }

    @XmlTransient
    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }

    @XmlTransient
    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    @XmlTransient
    public List<Agenda> getAgendaList() {
        return agendaList;
    }

    public void setAgendaList(List<Agenda> agendaList) {
        this.agendaList = agendaList;
    }

    @XmlTransient
    public List<Agenda> getAgendaList1() {
        return agendaList1;
    }

    public void setAgendaList1(List<Agenda> agendaList1) {
        this.agendaList1 = agendaList1;
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
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pessoa[ id=" + id + " ]";
    }
    
}
