/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import model.Pessoa;

/**
 *
 * @author Jessica
 */
public class PessoaDAO extends BaseDAO<Pessoa> {
    @Override
    public Pessoa Save(Pessoa pessoa) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
            return pessoa;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void Delete(int id) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            String jpql = "DELETE FROM pessoa p "
                    + "WHERE p.id = :id;";
            Query query = em.createQuery(jpql);
            query.setParameter("id", id);
            
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Pessoa Update(Pessoa pessoa) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            em.getTransaction().begin();
            em.merge(pessoa);
            em.getTransaction().commit();
            return pessoa;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Pessoa Insert(Pessoa pessoa) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            String jpql = "INSERT INTO pessoa p \n"
                    + "( nome, \n"
                    + " p.dt_nascimento, \n"
                    + " p.cpf, \n"
                    + " p.sexo, \n"
                    + " p.ativa, \n"
                    + " p.tipo_pessoa_id \n"
                    + ")\n"
                    + "VALUES\n"
                    + "( :nome,\n"
                    + " :dt_nascimento, \n"
                    + " :cpf, \n"
                    + " :sexo, \n"
                    + " :ativa, \n"
                    + " :tipo_pessoa_id \n"
                    + ");";
            Query query = em.createQuery(jpql);
            query.setParameter("nome", pessoa.getNome());
            query.setParameter("dtNascimento", pessoa.getDtNascimento());
            query.setParameter("cpf", pessoa.getCpf());
            query.setParameter("sexo", pessoa.getSexo());
            query.setParameter("ativa", pessoa.getAtiva());
            query.setParameter("pessoa", pessoa.getTipoPessoaId());

            Pessoa p = (Pessoa) query.getSingleResult();
            return p;
        } catch (NoResultException | NonUniqueResultException e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<Pessoa> All() {
        EntityManager em = null;
        try {
            em = OpenConnection();
            Query query = em.createNamedQuery("Pessoa.findAll");
            return query.getResultList();
        }catch (Exception ex){
            String teste = ex.toString();
            String teste2 = teste;
        }finally {
            if (em != null) {
                em.close();
            }
        }
        return null;
    }
    
    public List<Pessoa> getProfessores() {
        EntityManager em = null;
        try {
            em = OpenConnection();
            String jpql = "select a from Pessoa a "
                    + "where a.tipoPessoaId.id = 4";

            Query q = em.createQuery(jpql);
            List<Pessoa> a = (List<Pessoa>) q.getResultList();
            return a;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    
    public Pessoa FindById(Pessoa pessoa) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            String jpql = "SELECT p FROM Pessoa p " +
                            "WHERE p.id = :id";
            Query query = em.createQuery(jpql);
            query.setParameter("id", pessoa.getId());
            Pessoa c = (Pessoa) query.getSingleResult();
            return c;
        } catch (NoResultException | NonUniqueResultException e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
}
