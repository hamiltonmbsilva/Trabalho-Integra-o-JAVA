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
import model.PlanoPagamento;

/**
 *
 * @author Jessica
 */
public class PlanoPagamentoDAO extends BaseDAO<PlanoPagamento>{

    @Override
    public PlanoPagamento Save(PlanoPagamento planoPagamento) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            em.getTransaction().begin();
            em.persist(planoPagamento);
            em.getTransaction().commit();
            return planoPagamento;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void Delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PlanoPagamento Update(PlanoPagamento obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PlanoPagamento Insert(PlanoPagamento obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<PlanoPagamento> All() {
        EntityManager em = null;
        try {
            em = OpenConnection();
            Query query = em.createNamedQuery("PlanoPagamento.findAll");
            return query.getResultList();
        }finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public PlanoPagamento FindById(int id) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            String jpql = "SELECT p FROM PlanoPagamento p " +
                            "WHERE p.id = :id";
            Query query = em.createQuery(jpql);
            query.setParameter("id", id);
            PlanoPagamento c = (PlanoPagamento) query.getSingleResult();
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
