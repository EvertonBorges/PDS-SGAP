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
import modelo.Condomino;
import modelo.TipoUsuario;
import util.JPAUtil;

public class CondominoDAO {
    
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
    
    public void alteraCondomino(Condomino condomino){
        EntityManager manager = JPAUtil.getEntityManager();
       
        manager.getTransaction().begin();
        manager.merge(condomino);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public List<Condomino> listaCondominos(Condomino condomino){
        EntityManager manager = JPAUtil.getEntityManager();
        List<Condomino> condominos = null;
        
        try{
            CriteriaBuilder cb = manager.getCriteriaBuilder ();
            CriteriaQuery<Condomino> cq = cb.createQuery(Condomino.class);
            Root<Condomino> con = cq.from(Condomino.class);
            cq.select(con);
            
            Predicate predicate = cb.like(con.<String>get("nome"), "%"+condomino.getNome()+"%");
            cq.where(predicate);
            
            TypedQuery<Condomino> query = manager.createQuery(cq);
            condominos = query.getResultList();
        
        }
        catch(TypeNotPresentException ex){
            String consulta = "select con from Condomino con ";
            
            TypedQuery<Condomino> query = manager.createQuery(consulta, Condomino.class);
            
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
    
    public Condomino validarLogin(Condomino condomino){
        Condomino condominoResultado;
        
        EntityManager entitymanager = JPAUtil.getEntityManager();
        
        CriteriaBuilder cb = entitymanager.getCriteriaBuilder ();
        CriteriaQuery<Condomino> cq = cb.createQuery(Condomino.class);
        Root<Condomino> con = cq.from(Condomino.class);
        cq.select(con);
            
        Predicate predicate = cb.and(cb.equal(con.get("login"), condomino.getLogin()), cb.equal(con.get("senha"), condomino.getSenha()));
        cq.where(predicate);
            
        TypedQuery<Condomino> query = entitymanager.createQuery(cq);
        
        try{
            condominoResultado = query.getSingleResult();
        }
        catch(Exception noresult){
            condominoResultado = null;
        }
        
        return condominoResultado;
    }
    
    public List<Condomino> findCondominos(Condomino condomino){
        List<Condomino> condominos;
        EntityManager manager = JPAUtil.getEntityManager();
        TypedQuery<Condomino> query = manager.createQuery("SELECT c FROM Condomino c WHERE c.nome LIKE :nome AND c.tipoUsuario = :tipoUsuario", Condomino.class);
        query.setParameter("nome", condomino.getNome() + "%");
        query.setParameter("tipoUsuario", TipoUsuario.CONDOMINO);
        
        try {
            condominos = query.getResultList();
        } catch (NoResultException e) {
            condominos = null;
        }
        
        return condominos;
    }
    
    public boolean verificaLoginExistente(String login){
        EntityManager entitymanager = JPAUtil.getEntityManager();
        List<Condomino> condominos = null;
        boolean verifica = false;
        try{
            String consulta = "SELECT a FROM Condomino a WHERE a.login = :login ";
            
            TypedQuery<Condomino> query = entitymanager.createQuery(consulta, Condomino.class);
            query.setParameter("login", login);
            condominos = query.getResultList();
            System.out.println(condominos);
            if(condominos.isEmpty())
                verifica = false;
            else
                verifica = true;
        }
        catch(Exception noresult){
            noresult.getCause();
        }
        return verifica;
    }
}