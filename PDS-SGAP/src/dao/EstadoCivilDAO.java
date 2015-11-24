package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import modelo.EstadoCivil;
import util.JPAUtil;

public class EstadoCivilDAO {
    
    public void add(EstadoCivil estadoCivil){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(estadoCivil);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public void alter(EstadoCivil estadoCivil){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(estadoCivil);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public void remove(EstadoCivil estadoCivil){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.remove(estadoCivil);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public List<EstadoCivil> findEstadoCivil(EstadoCivil estadoCivil){
        List<EstadoCivil> estadosCivis;
        EntityManager manager = JPAUtil.getEntityManager();
        TypedQuery<EstadoCivil> query = manager.createQuery("SELECT e FROM EstadoCivil e WHERE e.descricao LIKE :descricao", EstadoCivil.class);
        query.setParameter("descricao", estadoCivil.getDescricao() + "%");
        
        try {
            estadosCivis = query.getResultList();
        } catch (NoResultException ex) {
            estadosCivis = null;
        }
        
        return estadosCivis;
    }
}