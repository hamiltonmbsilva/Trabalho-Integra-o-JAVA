/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Aluno;
import Models.AulaTeorica;
import Models.Professor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
public class AulaTeoricaDAO extends GenericDAO{
    
    public void save(AulaTeorica teorica) {
    
        EntityManager em = null;
        try{
            em = Open();
            em.getTransaction().begin();
            em.persist(teorica);
            em.getTransaction().commit();
        }
        finally{
            if(em != null){
                em.close();
            }
        }
    }
    
     public List<AulaTeorica> getAll() {
        EntityManager em = null;
        try {
            em = Open();

            Query q = em.createNamedQuery("AulaTeorica.findAll");

            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
     
    public AulaTeorica getById(int id) {
        EntityManager em = null;
        try {
            em = Open();
            String jpql = "SELECT a FROM AulaTeorica a WHERE a.id = :id";

            Query q = em.createQuery(jpql);
            q.setParameter("id", id);

            AulaTeorica a = (AulaTeorica) q.getSingleResult();
            return a;
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
     
    public void edit(AulaTeorica aula) {
        EntityManager em = null;
        try {
            em = Open();
            em.getTransaction().begin();
            em.merge(aula);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }    
    }
    
    public List<AulaTeorica> getPorProfessor(Professor professor) {
        EntityManager em = null;
        try {
            em = Open();

            Query q = em.createQuery("SELECT a FROM AulaTeorica a WHERE a.professorId = :professor");
            q.setParameter("professor", professor);

            return (List<AulaTeorica>) q.getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
