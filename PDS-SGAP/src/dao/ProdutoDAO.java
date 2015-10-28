/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import modelo.Produto;
import util.JPAUtil;

/**
 *
 * @author Everton Soares
 */
public class ProdutoDAO {

    public ProdutoDAO() {
    }
    
    public void addProduto(Produto produto){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(produto);
        manager.getTransaction().commit();
        manager.close();
        JOptionPane.showMessageDialog(null, "Produto inserido com sucesso", "Produto Inserido", JOptionPane.INFORMATION_MESSAGE);
    }
}
