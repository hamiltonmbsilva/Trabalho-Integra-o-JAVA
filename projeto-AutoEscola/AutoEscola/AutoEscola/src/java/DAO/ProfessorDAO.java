/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Login;
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
public class ProfessorDAO extends GenericDAO{
    
    public void save(Professor professor) {
    
        EntityManager em = null;
        try{
            em = Open();
            em.getTransaction().begin();
            em.persist(professor);
            em.getTransaction().commit();
        }
        finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public Professor BuscarPorLogin(Login idLogin) {
    
        EntityManager em = null;
        try{            
            em = Open();
            String jpql = "select p from Professor p where p.loginId = :idLogin";
            
            Query q = em.createQuery(jpql);
            q.setParameter("idLogin", idLogin);
            
            Professor professor = (Professor) q.getSingleResult();
            
            return professor;
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
    
     public List<Professor> getAll() {
        EntityManager em = null;
        try {
            em = Open();

            Query q = em.createNamedQuery("Professor.findAll");

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
