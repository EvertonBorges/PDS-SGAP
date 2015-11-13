package testes;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Condomino;
import util.JPAUtil;

public class ConsultaCondomino {
    public static void main(String[] args){
        EntityManager entityManager = JPAUtil.getEntityManager();
        
        Condomino c = new Condomino();
        c.setLogin("usuario");
        c.setSenha("123");
        c.setNome("Sousa");
            Query query = entityManager.createQuery("select c from Condomino as c where c.login = :login and c.senha = :senha" );
        query.setParameter("login", c.getLogin());
        query.setParameter("senha", c.getSenha());
        Condomino condomino;
        try {
            condomino =  (Condomino) query.getSingleResult();
            System.out.println("Funfou");
        } catch (Exception e) {
            System.out.println("Não existe");
        }
        
    }
}
