/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.TipoVeiculo;

/**
 *
 * @author Jessica
 */
public class TipoVeiculoDAO extends BaseDAO<TipoVeiculo>{

    @Override
    public TipoVeiculo Save(TipoVeiculo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoVeiculo Update(TipoVeiculo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoVeiculo Insert(TipoVeiculo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<TipoVeiculo> All() {
        EntityManager em = null;
        try {
            em = OpenConnection();
            Query query = em.createNamedQuery("TipoVeiculo.findAll");
            return query.getResultList();
        }finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
}
