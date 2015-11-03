/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Borges
 */
public class JPAUtil {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("PDS-SGAPPU");
    private EntityManager manager = factory.createEntityManager();

    public JPAUtil() {
        
    }

    public EntityManager getManager() {
        return manager;
    }
}