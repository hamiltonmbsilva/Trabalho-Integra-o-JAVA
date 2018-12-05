/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

/**
 *
 * @author Jessica
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jessica
 * @param <T>
 */
public abstract class BaseDAO<T> {
    
    public EntityManager OpenConnection() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cfc");
        EntityManager em = emf.createEntityManager();
        return em;
    }
    
    abstract public T Save(T obj);
    abstract public void Delete(int id);
    abstract public T Update(T obj);
    abstract public T Insert(T obj);   
}
