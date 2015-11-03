/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Administrador;
import util.JPAUtil;

/**
 *
 * @author Wilson
 */
public class AdministradorDAO {
    
    public void inserir(Administrador admin){
        
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(admin);
        entityManager.getTransaction().commit();
        entityManager.close();
        
    }
    
    public List<Administrador> listar(){
        
        EntityManager entityManager = JPAUtil.getEntityManager();
        Query query = entityManager.createQuery
                ("select a from Administrador a");
        List<Administrador> admins = query.getResultList();
       
        return admins;
    }
    
    public List<Administrador> pesquisar(Administrador admin){
        
        EntityManager entityManager = JPAUtil.getEntityManager();
                Query query = entityManager.createQuery("select a from Administrador as a where a.nome like :paramNome");
        query.setParameter("paramNome", "%"+admin.getNome()+"%");

        List<Administrador> admins = query.getResultList();
        
        return admins;
        
    }
    
    public void atualizar(Administrador admin){
        
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(admin);
        entityManager.getTransaction().commit();
        entityManager.close();
        
    }
    
    public void remover(Administrador admin){
        
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Administrador ad = entityManager.find(Administrador.class, admin.getCodigo());
        entityManager.remove(ad);
        entityManager.getTransaction().commit();
        entityManager.close();
        
    }
    
    public boolean validarLogin(Administrador admin){
        boolean existe;
        
        EntityManager entitymanager = JPAUtil.getEntityManager();
            Query query = entitymanager.createQuery("select a from Administrador as a where a.login = :login");
        query.setParameter("login", admin.getLogin());
        existe = query.getResultList().isEmpty();
        
        return existe;
    }
    
}
