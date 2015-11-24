package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import modelo.Categoria;
import util.JPAUtil;

public class CategoriaDAO {
    
    public void addCategoria(Categoria categoria){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(categoria);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public void alterCategoria(Categoria categoria){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(categoria);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public void removeCategoria(Categoria categoria){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.remove(categoria);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public List<Categoria> allCategorias(){
        EntityManager manager = JPAUtil.getEntityManager();
        Query query = manager.createQuery("SELECT c FROM Categoria c ORDER BY c.descricao");
        List<Categoria> categorias;
        try{
            categorias = query.getResultList();
        } catch(NoResultException ex){
            categorias = null;
        }
        return categorias;
    }
    
    public List<Categoria> findCategoria(Categoria categoria){
        List<Categoria> categoriasRetorno;
        EntityManager manager = JPAUtil.getEntityManager();
        Query query = manager.createQuery("SELECT c FROM Categoria c WHERE c.descricao LIKE :descricao ORDER BY c.codigo");
        query.setParameter("descricao", categoria.getDescricao() + "%");
        
        try {
            categoriasRetorno = query.getResultList();
        } catch (NoResultException e) {
            categoriasRetorno = null;
        }
        
        return categoriasRetorno;
    }
}