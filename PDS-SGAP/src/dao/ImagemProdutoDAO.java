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
import modelo.ImagemProduto;
import modelo.Produto;

/**
 *
 * @author Everton Soares
 */
public class ImagemProdutoDAO {
    
    public void addImagemProduto(ImagemProduto imagem, EntityManager manager){
        manager.persist(imagem);
    }
    
    public void removeImagemProduto(ImagemProduto imagemProduto, EntityManager manager){
        manager.remove(manager.getReference(ImagemProduto.class, imagemProduto.getCodigo()));
    }
    
    public List<ImagemProduto> listByProduto(Produto produto, EntityManager manager){
        List<ImagemProduto> imagensProduto;
        Query query = manager.createQuery("SELECT i FROM ImagemProduto i WHERE i.produto = :codigo");
        query.setParameter("codigo", produto.getCodigo());
        
        try{
            imagensProduto = query.getResultList();
        } catch (NoResultException ex) {
            imagensProduto = null;
        }
        return imagensProduto;
    }
}
