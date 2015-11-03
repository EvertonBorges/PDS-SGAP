/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
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
        JPAUtil jpaUtil = new JPAUtil();
        EntityManager manager = jpaUtil.getManager();
        manager.getTransaction().begin();
        manager.persist(condomino);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public Condomino getCondominoById(Long codigo){
        Condomino condomino;
        JPAUtil jpaUtil = new JPAUtil();
        EntityManager manager = jpaUtil.getManager();
        Query query = manager.createQuery("SELECT c FROM Condomino c WHERE c.codigo = :codigo");
        query.setParameter("codigo", codigo);
        try {
            condomino = (Condomino) query.getSingleResult();
        } catch (NoResultException ex) {
            condomino = null;
        }
        return condomino;
    }
}
