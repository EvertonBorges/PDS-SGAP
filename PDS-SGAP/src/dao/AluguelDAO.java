package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import modelo.Aluguel;
import util.JPAUtil;

public class AluguelDAO {
    
    List<Aluguel> alugueis = new ArrayList<>();

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    
    public AluguelDAO(){
        preencherLista();
    }
    
    public void preencherLista(){
        this.alugueis.clear();
        EntityManager manager = JPAUtil.getEntityManager();
        Query query = manager.createQuery("SELECT a FROM Aluguel a");
        try{
            this.alugueis = query.getResultList();
        } catch (NoResultException ex) {
            this.alugueis = null;
            System.out.println("\nErro ao buscar produtos");
        }
    }
    
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
}