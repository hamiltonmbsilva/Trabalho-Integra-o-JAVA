/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Aluno;
import Models.Pagamento;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
public class PagamentoDAO extends GenericDAO {

    public void save(Pagamento pagamento) {

        EntityManager em = null;
        try {
            em = Open();
            em.getTransaction().begin();
            em.persist(pagamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pagamento pagamento) {
        EntityManager em = null;
        try {
            em = Open();
            em.getTransaction().begin();
            em.merge(pagamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pagamento> getAll() {
        EntityManager em = null;
        try {
            em = Open();

            Query q = em.createNamedQuery("Pagamento.findAll");

            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Pagamento getByID(String id) {
        EntityManager em = null;
        try {
            em = Open();

            Query q = em.createNamedQuery("Pagamento.findById");
            q.setParameter("id", Integer.parseInt(id));

            return (Pagamento) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public Pagamento getPorAluno(Aluno aluno) {
        EntityManager em = null;
        try {
            em = Open();

            Query q = em.createQuery("Select p FROM Pagamento p WHERE p.alunoMatricula = :aluno ORDER BY p.dataPagamento DESC");
            q.setParameter("aluno", aluno);

            return (Pagamento) q.setMaxResults(1).getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
