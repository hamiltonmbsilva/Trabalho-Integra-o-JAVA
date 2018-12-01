/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class GenericDAO {
    
    public EntityManager Open() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AutoEscolaPU");
        EntityManager em = emf.createEntityManager();
        return em;
    }
    
}