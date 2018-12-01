/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Aluno;
import Models.Login;
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
public class AlunoDAO extends GenericDAO{
    
    public void save(Aluno aluno) {
    
        EntityManager em = null;
        try{
            em = Open();
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
        }
        finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public Aluno BuscarPorLogin(Login idLogin) {
    
        EntityManager em = null;
        try{            
            em = Open();
            String jpql = "select a from Aluno a where a.loginId = :idLogin";
            
            Query q = em.createQuery(jpql);
            q.setParameter("idLogin", idLogin);
            
            Aluno aluno = (Aluno) q.getSingleResult();
            
            return aluno;
        }
        catch(NoResultException e){
            return null;
        }
        catch(NonUniqueResultException e){
            return null;
        }
        finally{
           if(em != null){
                em.close();
            } 
        } 
    }
    
    public void edit(Aluno aluno) {
        EntityManager em = null;
        try {
            em = Open();
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }    
    }
    
     public List<Aluno> getAll() {
        EntityManager em = null;
        try {
            em = Open();

            Query q = em.createNamedQuery("Aluno.findAll");

            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
     
      public Aluno getByID(String id) {
        EntityManager em = null;
        try {
            em = Open();

            Query q = em.createNamedQuery("Aluno.findByMatricula");
            q.setParameter("matricula", Integer.parseInt(id));

            return (Aluno) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
      
       public List<Aluno> getAllMatriculados() {
        EntityManager em = null;
        try {
            em = Open();
            String jpql = "SELECT a FROM Aluno a WHERE a.matriculado != false";

            Query q = em.createQuery(jpql);

            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
}
