/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import modelo.Apartamento;
import modelo.Condomino;
import util.JPAUtil;

/**
 *
 * @author Borges
 */
public class CondominoDAO {

    public CondominoDAO() {
    }
    
    public void addCondomino(Condomino condomino){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(condomino);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public Condomino getCondominoById(Long codigo){
        
        Condomino condomino;
        EntityManager manager = JPAUtil.getEntityManager();
        Query query = manager.createQuery("SELECT c FROM Condomino c WHERE c.codigo = :codigo");
        query.setParameter("codigo", codigo);
        try {
            condomino = (Condomino) query.getSingleResult();
        } catch (NoResultException ex) {
            condomino = null;
        }
        return condomino;
        
    }
    
    public void insereCondomino(Condomino condomino){
        
        EntityManager manager = JPAUtil.getEntityManager();
       
        manager.getTransaction().begin();
        
        String consulta = "select ap from Apartamento ap "
                        + "where ap.bloco = :bloco "
                        + "and ap.andar = :andar "
                        + "and ap.numApartamento = :numApartamento";
       
        TypedQuery<Apartamento> query = manager.createQuery(consulta, Apartamento.class);
        query.setParameter("bloco", condomino.getApartamento().getBloco());
        query.setParameter("andar", condomino.getApartamento().getAndar());
        query.setParameter("numApartamento", condomino.getApartamento().getNumApartamento());
        
        Apartamento apartamento = query.getSingleResult();
        
        condomino.setApartamento(apartamento);
        
        manager.persist(condomino);
        manager.getTransaction().commit();
        manager.close();
        
    }
    
    public void alteraCondomino(Condomino condomino){
        
        EntityManager manager = JPAUtil.getEntityManager();
       
        Condomino condominoAlterado;
        manager.getTransaction().begin();
        
        condominoAlterado = manager.find(Condomino.class, condomino.getCodigo());        
        
        condominoAlterado.setNome(condomino.getNome());
        condominoAlterado.setCpf(condomino.getCpf());
        condominoAlterado.setDataNascimento(condomino.getDataNascimento());
        condominoAlterado.setEstadoCivil(condomino.getEstadoCivil());
        condominoAlterado.setTelefones(condomino.getTelefones());
        condominoAlterado.setLogin(condomino.getLogin());
        condominoAlterado.setSenha(condomino.getSenha());
        condominoAlterado.setApartamento(condomino.getApartamento());
        
        manager.getTransaction().commit();
        manager.close();
    }
    
    public List<Condomino> listaCondominos(Condomino condomino){
        EntityManager manager = JPAUtil.getEntityManager();
        List<Condomino> condominos = null;
        
        if(condomino.getNome().isEmpty()){
            String consulta = "select con from Condomino con ";
            
            TypedQuery<Condomino> query = manager.createQuery(consulta, Condomino.class);
            
            condominos = query.getResultList();
        }
        
        else{
            CriteriaBuilder cb = manager.getCriteriaBuilder ();
            CriteriaQuery<Condomino> cq = cb.createQuery(Condomino.class);
            Root<Condomino> con = cq.from(Condomino.class);
            cq.select(con);
            
            Predicate predicate = cb.like(con.<String>get("nome"), "%"+condomino.getNome()+"%");
            cq.where(predicate);
            
            TypedQuery<Condomino> query = manager.createQuery(cq);
            condominos = query.getResultList();
        }
        
        manager.close();
        
        return condominos;
    }
    
    public void excluiCondomino(Condomino condomino){
        
        EntityManager manager = JPAUtil.getEntityManager();
        
        Condomino condominoAlterado;
        manager.getTransaction().begin();
        
        condominoAlterado = manager.find(Condomino.class, condomino.getCodigo());        
        manager.remove(condominoAlterado);
        
        manager.getTransaction().commit();
        manager.close();
    }
    
}
