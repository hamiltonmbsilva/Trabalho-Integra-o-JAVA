/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Login;
import Models.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
public class PessoaDAO extends GenericDAO{
    
    public void save(Pessoa pessoa) {
    
        EntityManager em = null;
        try{
            em = Open();
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
        }
        finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public Pessoa BuscarPorLogin(Login idLogin) {
    
        EntityManager em = null;
        try{            
            em = Open();
            String jpql = "select p from Pessoa p where p.loginId = :idLogin";
            
            Query q = em.createQuery(jpql);
            q.setParameter("idLogin", idLogin);
            
            Pessoa aluno = (Pessoa) q.getSingleResult();
            
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
    
}
