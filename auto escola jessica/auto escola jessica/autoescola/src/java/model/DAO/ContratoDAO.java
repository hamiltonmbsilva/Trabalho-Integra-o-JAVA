/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import static java.io.FileDescriptor.out;
import static java.lang.System.exit;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import model.Contrato;
import model.Pessoa;

/**
 *
 * @author Jessica
 */
public class ContratoDAO extends BaseDAO<Contrato> {

    @Override
    public Contrato Save(Contrato contrato) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            em.getTransaction().begin();
            em.persist(contrato);
            em.getTransaction().commit();
            return contrato;
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
            em.getTransaction().begin();
            Contrato c = new Contrato(id);
            c = em.getReference(Contrato.class, c.getId());
            c.setRecebimentoList(null);
            em.merge(c);
//            em.remove(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Contrato Update(Contrato contrato) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            em.getTransaction().begin();
            em.merge(contrato);
            em.getTransaction().commit();
            return contrato;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Contrato Insert(Contrato obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Contrato> All() {
        EntityManager em = null;
        try {
            em = OpenConnection();
            Query query = em.createNamedQuery("Contrato.findAll");
            return query.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Contrato FindById(int id) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            String jpql = "SELECT p FROM Contrato p " +
                            "WHERE p.id = :id";
            Query query = em.createQuery(jpql);
            query.setParameter("id", id);
            Contrato c = (Contrato) query.getSingleResult();
            return c;
        } catch (NoResultException | NonUniqueResultException e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Contrato> FindByPersonId(Pessoa pessoa) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            String jpql = "SELECT c FROM Contrato c WHERE c.pessoaId.id = :id";
            Query query = em.createQuery(jpql);
            query.setParameter("id", pessoa.getId());
            List<Contrato> c = (List<Contrato>) query.getResultList();
            return c;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
