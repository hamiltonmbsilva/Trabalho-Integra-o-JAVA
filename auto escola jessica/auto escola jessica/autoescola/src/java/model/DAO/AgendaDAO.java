/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Agenda;

/**
 *
 * @author Jessica
 */
public class AgendaDAO extends BaseDAO<Agenda>{

    @Override
    public Agenda Save(Agenda agenda) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            em.getTransaction().begin();
            em.persist(agenda);
            em.getTransaction().commit();
            return agenda;
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
    public Agenda Update(Agenda obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Agenda Insert(Agenda obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Agenda> All() {
        EntityManager em = null;
        try {
            em = OpenConnection();
            Query query = em.createNamedQuery("Agenda.findAll");
            return query.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<Agenda> getAulasDisponiveis() {
        EntityManager em = null;
        try {
            em = OpenConnection();
            String jpql = "select a from Agenda a "
                    + "where a.disponivel = 1";

            Query q = em.createQuery(jpql);
            List<Agenda> a = (List<Agenda>) q.getResultList();
            return a;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
