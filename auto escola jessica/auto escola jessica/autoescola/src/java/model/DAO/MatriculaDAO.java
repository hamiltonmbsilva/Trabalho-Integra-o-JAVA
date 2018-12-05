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
import model.Matricula;
import model.Pessoa;

/**
 *
 * @author Jessica
 */
public class MatriculaDAO extends BaseDAO<Matricula> {

    @Override
    public Matricula Save(Matricula matricula) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            em.getTransaction().begin();
            em.persist(matricula);
            em.getTransaction().commit();
            return matricula;
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
    public Matricula Update(Matricula obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Matricula Insert(Matricula obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Matricula Login(String login, String senha) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            String jpql = "select a from Matricula a "
                    + "where a.login = :log and a.senha = :sen ";

            Query q = em.createQuery(jpql);
            q.setParameter("log", login);
            q.setParameter("sen", senha);
            Matricula a = (Matricula) q.getSingleResult();
            return a;
        } catch (NoResultException | NonUniqueResultException e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Matricula getMatricula(int id) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            String jpql = "select a from Matricula a "
                    + "where a.pessoaId = :id";

            Query q = em.createQuery(jpql);
            q.setParameter("id", id);
            Matricula a = (Matricula) q.getSingleResult();
            return a;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<Matricula> All() {
        EntityManager em = null;
        try {
            em = OpenConnection();
            //NamedQuery são aqueles metodos que estão nas classes @NamedQueries
            Query query = em.createNamedQuery("Matricula.findAll");
            return query.getResultList();
        }finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
