package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import modelo.EstadoCivil;
import util.JPAUtil;

public class EstadoCivilDAO {
    
    public void insereEstadoCivil(){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<EstadoCivil> estadoCivil = criteriaQuery.from(EstadoCivil.class);
        
        List<String> estadoCivis = new ArrayList<>();
        estadoCivis.add("Solteiro");
        estadoCivis.add("Casado");
        estadoCivis.add("Divorciado");
        estadoCivis.add("Viúvo");
        
        for(String s : estadoCivis){
            criteriaQuery.select(estadoCivil.<String>get("descricao"));
            Predicate predicate = criteriaBuilder.equal(estadoCivil.get("descricao"), s);
            criteriaQuery.where(predicate);
        
            TypedQuery<String> query = manager.createQuery(criteriaQuery);
            
            try{
               String resultado = query.getSingleResult();
            }
            catch(Exception noresult){
                EstadoCivil ec = new EstadoCivil();
                ec.setDescricao(s);
                manager.persist(ec);
            }
        }
        manager.getTransaction().commit();
        manager.close();
    }
    
    public List<EstadoCivil> listaEstadoCivil(){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        
        String consulta = "select ec from EstadoCivil ec";
        TypedQuery<EstadoCivil> query = manager.createQuery(consulta, EstadoCivil.class);
        List<EstadoCivil> estadosCivis = query.getResultList();
        
        manager.getTransaction().commit();
        manager.close();
        
        return estadosCivis;
    }
}