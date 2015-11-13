package testes;

import javax.persistence.EntityManager;
import modelo.Condomino;
import util.JPAUtil;

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
