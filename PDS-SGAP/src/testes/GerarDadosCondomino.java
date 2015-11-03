/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import javax.persistence.EntityManager;
import modelo.Condomino;
import util.JPAUtil;

/**
 *
 * @author Wilson
 */
public class GerarDadosCondomino {
    public static void main(String[] args){
        EntityManager entityManager =  JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Condomino condomino = new Condomino();
        condomino.setLogin("usuario");
        condomino.setSenha("123");
        entityManager.persist(condomino);
        entityManager.getTransaction().commit();
        entityManager.close();
        JPAUtil.emf.close();
    }
}
