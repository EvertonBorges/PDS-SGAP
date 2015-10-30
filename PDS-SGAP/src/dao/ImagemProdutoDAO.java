/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import modelo.ImagemProduto;
import util.JPAUtil;

/**
 *
 * @author Everton Soares
 */
public class ImagemProdutoDAO {
    
    public void addImagemProduto(ImagemProduto imagem){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(imagem);
        manager.getTransaction().commit();
        manager.close();
    }
}
