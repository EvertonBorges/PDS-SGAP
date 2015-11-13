package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import modelo.Apartamento;
import util.JPAUtil;

public class ApartamentoDAO {
    
    public void inserir(Apartamento apto){
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(apto);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public void atualizar(Apartamento apto){
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(apto);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public void remove(Apartamento apto){
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Apartamento ap = entityManager.find(Apartamento.class, apto.getCodigo());
        entityManager.remove(ap);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public List<Apartamento> listar(){
        EntityManager entityManager = JPAUtil.getEntityManager();
        Query query = entityManager.createQuery
                ("select a from Apartamento a");
        List<Apartamento> aptos = query.getResultList();
       
        return aptos;
    }
    
    public List<Character> listaBloco(){
        EntityManager manager = JPAUtil.getEntityManager();
        
        String consulta = "select distinct ap.bloco from Apartamento ap "
                        + "order by ap.bloco asc";
        
        TypedQuery<Character> query = manager.createQuery(consulta, Character.class);
        
        List<Character> blocos = query.getResultList();
        
        manager.close();
        
        return blocos;
    }
    
    public List<Integer> listaAndar(Character bloco){
        EntityManager manager = JPAUtil.getEntityManager();
        
        String consulta = "select distinct ap.andar from Apartamento ap "
                        + "where ap.bloco = :bloco "
                        + "order by ap.andar asc";
       
        TypedQuery<Integer> query = manager.createQuery(consulta, Integer.class);
        query.setParameter("bloco", bloco);
        
        List<Integer> andares = query.getResultList();
        
        manager.close();
        
        return andares;
    }
    
    public List<String> listaNumApartamento(Character bloco, int andar){
        EntityManager manager = JPAUtil.getEntityManager();
        
        String consulta = "select distinct ap.numApartamento from Apartamento ap "
                        + "where ap.bloco = :bloco "
                        + "and ap.andar = :andar "
                        + "order by ap.numApartamento asc";
        
        TypedQuery<String> query = manager.createQuery(consulta, String.class);
        query.setParameter("bloco", bloco);
        query.setParameter("andar", andar);
        
        List<String> numAp = query.getResultList();
        
        manager.close();
        
        return numAp;
    }
    
    public Apartamento apartamento(char bloco, int andar, String numApartamento){
        EntityManager manager = JPAUtil.getEntityManager();
       
        manager.getTransaction().begin();
        
        String consulta = "select ap from Apartamento ap "
                        + "where ap.bloco = :bloco "
                        + "and ap.andar = :andar "
                        + "and ap.numApartamento = :numApartamento";
        
        TypedQuery<Apartamento> query = manager.createQuery(consulta, Apartamento.class);
        query.setParameter("bloco", bloco);
        query.setParameter("andar", andar);
        query.setParameter("numApartamento", numApartamento);
        
        Apartamento ap = query.getSingleResult();
        
        manager.getTransaction().commit();
        manager.close();
        
        return ap;
    }
}