/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Aluno;
import Models.AulaPratica;
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
public class AulaPraticaDAO extends GenericDAO{
    
    public void save(AulaPratica teorica) {
    
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
    
     public List<AulaPratica> getAll() {
        EntityManager em = null;
        try {
            em = Open();

            Query q = em.createNamedQuery("AulaPratica.findAll");

            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
     
     public AulaPratica getById(int id) {
        EntityManager em = null;
        try {
            em = Open();
            String jpql = "SELECT a FROM AulaPratica a WHERE a.id = :id";

            Query q = em.createQuery(jpql);
            q.setParameter("id", id);

            AulaPratica a = (AulaPratica) q.getSingleResult();
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
     
     public void edit(AulaPratica aula) {
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
     
     public List<AulaPratica> getPorAluno(Aluno aluno) {
        EntityManager em = null;
        try {
            em = Open();

            Query q = em.createQuery("SELECT a FROM AulaPratica a WHERE a.alunoMatricula = :aluno");
            q.setParameter("aluno", aluno);

            return (List<AulaPratica>) q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
     
      public List<AulaPratica> getSemAluno() {
        EntityManager em = null;
        try {
            em = Open();

            Query q = em.createQuery("SELECT a FROM AulaPratica a WHERE a.alunoMatricula IS NULL");

            return (List<AulaPratica>) q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
      
      public List<AulaPratica> getPorProfessor(Professor professor) {
        EntityManager em = null;
        try {
            em = Open();

            Query q = em.createQuery("SELECT a FROM AulaPratica a WHERE a.professorId = :professor");
            q.setParameter("professor", professor);

            return (List<AulaPratica>) q.getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
}
