package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import modelo.Aluguel;
import util.JPAUtil;

public class AluguelDAO {
    
    public void addAluguel(Aluguel aluguelAdicionar){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(aluguelAdicionar);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public void removeAluguel(Aluguel aluguelExclusao){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.remove(aluguelExclusao);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public void alterAluguel(Aluguel aluguelAlteracao){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(aluguelAlteracao);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public List<Aluguel> findAlugueis(){
        List<Aluguel> alugueis;
        EntityManager manager = JPAUtil.getEntityManager();
        TypedQuery<Aluguel> query = manager.createQuery("SELECT a FROM Aluguel a", Aluguel.class);
        
        try {
            alugueis = query.getResultList();
        } catch (NoResultException e) {
            alugueis = null;
        }
        
        return alugueis;
    }
}