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
import modelo.Categoria;
import modelo.Produto;
import util.JPAUtil;

/**
 *
 * @author Everton Soares
 */
public class CategoriaDAO {
    
    public void addCategoria(Categoria categoria){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(categoria);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public void persistByProduto(Produto produto, EntityManager manager){
        manager.persist(produto);
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

}
