/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Produto;

/**
 *
 * @author Everton Soares
 */
public class testeProduto {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PDS-SGAPPU");
    private static final EntityManager manager = factory.createEntityManager();

    public static void main(String args[]){
        Produto produto = new Produto();
        produto.setNome("Teste 2");
        produto.setQuantidade(1);
        produto.setDescricao("Teste 2, Teste 2");
        produto.setImagens(new ArrayList<>());
        manager.getTransaction().begin();
        manager.persist(produto);
        manager.getTransaction().commit();
        manager.close();
    }
}