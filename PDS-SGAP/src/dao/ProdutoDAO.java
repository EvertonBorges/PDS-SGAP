/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
     
    private List<Produto> produtos =  new ArrayList<>();
    
    public ProdutoDAO() {
        preencherLista();
    }
    
    public void preencherLista(){
        this.produtos.clear();
        EntityManager manager = JPAUtil.getEntityManager();
        Query query = manager.createQuery("SELECT p FROM Produto p ");
        try{
            this.produtos = query.getResultList();
        } catch (NoResultException ex) {
            this.produtos = null;
            System.out.println("\nerro ao buscar produtos");
        }
    }
    
    public List<Produto> getProdutos() {
        return produtos;
    }
    
    public void addProduto(Produto produto){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(produto);
        for (ImagemProduto imagem: produto.getImagensProduto()){
            ImagemProdutoDAO imagemProdutoDAO = new ImagemProdutoDAO();
            imagemProdutoDAO.addImagemProduto(imagem, manager);
        }
        manager.getTransaction().commit();
        manager.close();
        JOptionPane.showMessageDialog(null, "Produto inserido com sucesso", "Produto Inserido", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void alterProduto(Produto produtoNovo, List<ImagemProduto> imagensNovas){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        if (!produtoNovo.getImagensProduto().isEmpty()){
            for (ImagemProduto imagem: produtoNovo.getImagensProduto()) {
                ImagemProdutoDAO imagemProdutoDAO = new ImagemProdutoDAO();
                imagemProdutoDAO.removeImagemProduto(imagem, manager);
            }
        }
        if (!imagensNovas.isEmpty()) {
            for (ImagemProduto imagem: imagensNovas) {
                ImagemProdutoDAO imagemProdutoDAO = new ImagemProdutoDAO();
                imagemProdutoDAO.addImagemProduto(imagem, manager);
            }
        }
        Produto produto = manager.find(Produto.class, produtoNovo.getCodigo());
        produto.setNome(produtoNovo.getNome());
        produto.setQuantidade(produtoNovo.getQuantidade());
        produto.setTaxa(produtoNovo.getTaxa());
        produto.setDiaria(produtoNovo.getDiaria());
        produto.setCategorias(produtoNovo.getCategorias());
        produto.setDescricao(produtoNovo.getDescricao());
        produto.setImagensProduto(imagensNovas);
        
        manager.getTransaction().commit();
        manager.close();
        JOptionPane.showMessageDialog(null, "Produto alterado com sucesso", "Produto Alterado", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void removeProduto(Produto produto){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        Produto produtoRemover = manager.find(Produto.class, produto.getCodigo());
        for (ImagemProduto imagemProduto: produtoRemover.getImagensProduto()) {
            ImagemProdutoDAO imagemProdutoDAO = new ImagemProdutoDAO();
            imagemProdutoDAO.removeImagemProduto(imagemProduto, manager);
        }
        manager.remove(produtoRemover);
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
    
    public List<Produto> findProdutoByCategoria(Categoria categoria, EntityManager manager){
        List<Produto> produtosRetorno;
        String consulta="select p from Produto p where categoria_codigo = :codigo";
        TypedQuery<Produto> query = manager.createQuery(consulta, Produto.class);
        query.setParameter("codigo", categoria.getCodigo());
        
        try{
            produtosRetorno = query.getResultList();
        } catch (NoResultException ex) {
            produtosRetorno = null;
            System.out.println("Erro ao procurar produtos por categoria: " + ex.getMessage());
        }
        return produtosRetorno;
    }
    
    public List<Produto> findProdutoByStatus(boolean status, EntityManager manager){
        List<Produto> produtosRetorno;
        Query query = manager.createQuery("SELECT p FROM Produto p WHERE p.status = :status");
        query.setParameter("status", status);
        try{
            produtosRetorno = query.getResultList();
        } catch (NoResultException ex) {
            produtosRetorno = null;
            System.out.println("Erro ao procurar produtos por categoria: " + ex.getMessage());
        }
        return produtosRetorno;
    }
}