/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.TipoPessoa;

/**
 *
 * @author Jessica
 */
public class TipoPessoaDAO extends BaseDAO<TipoPessoa>{

    @Override
    public TipoPessoa Save(TipoPessoa obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoPessoa Update(TipoPessoa obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoPessoa Insert(TipoPessoa obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<TipoPessoa> All() {
        EntityManager em = null;
        try {
            em = OpenConnection();
            Query query = em.createNamedQuery("TipoPessoa.findAll");
            return query.getResultList();
        }finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
}
