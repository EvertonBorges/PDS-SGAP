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
import javax.swing.JOptionPane;
import modelo.Categoria;
import modelo.Condomino;
import modelo.ImagemProduto;
import modelo.Produto;
import util.JPAUtil;

/**
 *
 * @author Everton Soares
 */
public class ProdutoDAO {

    public ProdutoDAO() {
    }
    
    public void addProduto(Produto produto, List<ImagemProduto> imagens, List<Categoria> categorias){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(produto);
        for (ImagemProduto imagem: imagens){
            ImagemProdutoDAO imagemProdutoDAO = new ImagemProdutoDAO();
            imagemProdutoDAO.addImagemProduto(imagem, manager);
        }
        for (Categoria categoria: categorias){
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            categoriaDAO.persistByProduto(produto, manager);
        }
        manager.getTransaction().commit();
        manager.close();
        JOptionPane.showMessageDialog(null, "Produto inserido com sucesso", "Produto Inserido", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void alterProduto(Produto produto){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        Produto produtoAlteracao = findProdutoById(produto, manager);
        if (produtoAlteracao != null) {
            
        }
    }
    
    public void removeProduto(Produto produto){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.remove(produto);
        manager.getTransaction().commit();
        manager.close();
        JOptionPane.showMessageDialog(null, "Produto excluido com sucesso", "Produto Excluido", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public List<Produto> findProdutoByCondomino(Condomino condomino){
        List<Produto> produtosRetorno;
        EntityManager manager = JPAUtil.getEntityManager();
        Query query = manager.createQuery("SELECT p FROM Produto p WHERE p.condomino.codigo = :condominoCodigo");
        query.setParameter("condominoCodigo", condomino.getCodigo());
        try{
            produtosRetorno = query.getResultList();
        } catch (NoResultException ex) {
            produtosRetorno = null;
        }
        return produtosRetorno;
    }
    
    public Produto findProdutoById(Produto produto, EntityManager manager){
        Produto produtoRetorno;
        Query query = manager.createQuery("SELECT p FROM Produto p WHERE p.codigo = :codigo");
        query.setParameter("codigo", produto.getCodigo());
        try{
            produtoRetorno = (Produto) query.getSingleResult();
        } catch (NoResultException ex) {
            produtoRetorno = null;
        }
        return produtoRetorno;
    }
}