/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Login;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
public class LoginDAO extends GenericDAO{
    
    public void save(Login login) {
    
        EntityManager em = null;
        try{
            em = Open();
            em.getTransaction().begin();
            em.persist(login);
            em.getTransaction().commit();
        }
        finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public Login BuscaPorLogin(String login)
    {
        EntityManager em = null;
        try{            
            em = Open();
            String jpql = "select l from Login l where l.login = :login";
            
            Query q = em.createQuery(jpql);
            q.setParameter("login", login);
            
            Login log = (Login) q.getSingleResult();
            
            return log;
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
    
    public Login validaLogin(String login, String senha) {
    
        EntityManager em = null;
        try{            
            em = Open();
            String jpql = "select l from Login l where l.login = :log and l.senha = :sen";
            
            Query q = em.createQuery(jpql);
            q.setParameter("log", login);
            q.setParameter("sen", senha);
            
            Login log = (Login) q.getSingleResult();
            
            return log;
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
    
}
