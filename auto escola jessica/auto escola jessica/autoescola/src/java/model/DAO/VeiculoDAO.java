/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import model.Veiculo;

/**
 *
 * @author Jessica
 */
public class VeiculoDAO extends BaseDAO<Veiculo>{

    @Override
    public Veiculo Save(Veiculo veiculo) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            em.getTransaction().begin();
            em.persist(veiculo);
            em.getTransaction().commit();
            return veiculo;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void Delete(int id) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            String jpql = "DELETE FROM veiculo v \n"
                    + "WHERE v.id = :id;";
            Query query = em.createQuery(jpql);
            query.setParameter("id", id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Veiculo Update(Veiculo veiculo) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            String jpql = "UPDATE veiculo v \n" +
                                " SET \n" +
                                " ano  = :ano,\n" +
                                " placa  = :placa,\n" +
                                " tipoVeiculoId  = :tipo_veiculo_id \n" +
                                " WHERE  id = :id;";
            Query query = em.createQuery(jpql);
            query.setParameter("ano", veiculo.getAno());
            query.setParameter("placa", veiculo.getPlaca());
            query.setParameter("tipoVeiculoId", veiculo.getTipoVeiculoId());
            query.setParameter("id", veiculo.getId());

            Veiculo v = (Veiculo) query.getSingleResult();
            return v;
        } catch (NoResultException | NonUniqueResultException e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Veiculo Insert(Veiculo veiculo) {
        EntityManager em = null;
        try {
            em = OpenConnection();
            String jpql = "INSERT INTO veiculo v \n" +
                                " v.ano ,\n" +
                                " v.placa ,\n" +
                                " v.tipoVeiculoId )\n" +
                            " VALUES \n" +
                                " :ano,\n" +
                                " :placa ,\n" +
                                " :tipo_veiculo_id );";
            Query query = em.createQuery(jpql);
            query.setParameter("ano", veiculo.getAno());
            query.setParameter("placa", veiculo.getPlaca());
            query.setParameter("tipoVeiculoId", veiculo.getTipoVeiculoId());

            Veiculo v = (Veiculo) query.getSingleResult();
            return v;
        } catch (NoResultException | NonUniqueResultException e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<Veiculo> All() {
        EntityManager em = null;
        try {
            em = OpenConnection();
            Query query = em.createNamedQuery("Veiculo.findAll");
            return query.getResultList();
        }finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
}