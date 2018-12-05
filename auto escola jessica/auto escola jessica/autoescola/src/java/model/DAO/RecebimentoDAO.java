/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Pessoa;
import model.Recebimento;

/**
 *
 * @author Jessica
 */
public class RecebimentoDAO extends BaseDAO<Recebimento>{

    @Override
    public Recebimento Save(Recebimento recebimento) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            em.getTransaction().begin();
            em.persist(recebimento);
            em.getTransaction().commit();
            return recebimento;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public Recebimento Update(Recebimento recebimento) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            em.getTransaction().begin();
            em.merge(recebimento);
            em.getTransaction().commit();
            return recebimento;
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
            Recebimento c = new Recebimento(id);
            c = em.getReference(Recebimento.class, c.getId());
            em.merge(c);
            em.remove(c);
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
    public Recebimento Insert(Recebimento obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Recebimento> All() {
        EntityManager em = null;
        try {
            em = OpenConnection();
            //NamedQuery são aqueles metodos que estão nas classes @NamedQueries
            Query query = em.createNamedQuery("Recebimento.findAll");
            return query.getResultList();
        }finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<Recebimento> FindByPersonId(int pessoa) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            String jpql = "SELECT c FROM Recebimento c WHERE c.contratoId.pessoaId.id = :id";
            Query query = em.createQuery(jpql);
            query.setParameter("id", pessoa);
            List<Recebimento> c = (List<Recebimento>) query.getResultList();
            return c;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
