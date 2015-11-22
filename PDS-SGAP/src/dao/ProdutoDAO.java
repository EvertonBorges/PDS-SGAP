package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import modelo.Aluguel;
import modelo.Categoria;
import modelo.Condomino;
import modelo.ImagemProduto;
import modelo.Produto;
import util.JPAUtil;

public class ProdutoDAO {
     
    private List<Produto> produtos =  new ArrayList<>();
    
    public ProdutoDAO() {
        preencherLista();
    }
    
    private void preencherLista(){
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
            manager.persist(imagem);
        }
        manager.getTransaction().commit();
        manager.close();
    }
    
    public void alterProduto(Produto produto, List<ImagemProduto> imagensNovas){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(produto);
        List<ImagemProduto> imagensAntigas = produto.getImagensProduto();
        produto.setImagensProduto(imagensNovas);
        
        for (ImagemProduto imagem: imagensAntigas) {
            manager.remove(manager.getReference(ImagemProduto.class, imagem.getCodigo()));
        }
        for (ImagemProduto imagem: imagensNovas) {
            manager.persist(imagem);
        }
        
        manager.getTransaction().commit();
        manager.close();
    }
    
    public void removeProduto(Produto produto){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        Produto produtoRemover = manager.find(Produto.class, produto.getCodigo());
        for (ImagemProduto imagemProduto: produtoRemover.getImagensProduto()) {
            manager.remove(manager.getReference(ImagemProduto.class, imagemProduto.getCodigo()));
        }
        manager.remove(produtoRemover);
        manager.getTransaction().commit();
        manager.close();
    }
    
    public List<Produto> findProduto(Condomino condomino){
        EntityManager manager = JPAUtil.getEntityManager();
        List<Produto> produtosRetorno;
        TypedQuery<Produto> query = manager.createQuery("SELECT p FROM Produto p", Produto.class);
        try{
            produtosRetorno = query.getResultList();
        } catch (NoResultException ex) {
            produtosRetorno = null;
        }
        return produtosRetorno;
    }
    
    public List<Produto> findProduto(Condomino condomino, Produto produto){
        EntityManager manager = JPAUtil.getEntityManager();
        List<Produto> produtosRetorno;
        Query query = manager.createQuery("SELECT p FROM Produto p WHERE p.condomino.codigo = :codigo AND p.nome LIKE :nome");
        query.setParameter("codigo", condomino.getCodigo());
        query.setParameter("nome", produto.getNome()+ "%");
        produtosRetorno = query.getResultList();
        return produtosRetorno;
    }
    
    public List<Produto> findProduto(Produto produto){
        EntityManager manager = JPAUtil.getEntityManager();
        List<Produto> produtosRetorno;
        Query query = manager.createQuery("SELECT p FROM Produto p WHERE p.nome LIKE :nome");
        query.setParameter("nome", produto.getNome()+ "%");
        try {
            produtosRetorno = query.getResultList();
        } catch (NoResultException e) {
            produtosRetorno = null;
        }
        return produtosRetorno;
    }
    
    
    public Produto findProduto(Long codigo, EntityManager manager){
        Produto produtoRetorno;
        Query query = manager.createQuery("SELECT p FROM Produto p WHERE p.codigo = :codigo");
        query.setParameter("codigo", codigo);
        try{
            produtoRetorno = (Produto) query.getSingleResult();
        } catch (NoResultException ex) {
            produtoRetorno = null;
        }
        return produtoRetorno;
    }
    
    public List<Produto> findProduto(Categoria categoria, EntityManager manager){
        Categoria c;
        String consulta="select c from Categoria c where c.codigo = :codigo";
        TypedQuery<Categoria> query = manager.createQuery(consulta, Categoria.class);
        query.setParameter("codigo", categoria.getCodigo());
        
        try{
            c = (Categoria) query.getSingleResult();
        } catch (NoResultException ex) {
            c = null;
            System.out.println("Erro ao procurar produtos por categoria: " + ex.getMessage());
        }
        List<Produto> produtosRetorno = c.getProdutos();
        return produtosRetorno;
    }
    
    public List<Produto> findProduto(boolean status, Produto produto){
        EntityManager manager = JPAUtil.getEntityManager();
        List<Produto> produtosRetorno;
        Query query = manager.createQuery("SELECT p FROM Produto p WHERE p.status = :status AND  p.nome LIKE :nome ");
        query.setParameter("nome", produto.getNome()+ "%");
        query.setParameter("status", status);
        try{
            produtosRetorno = query.getResultList();
        } catch (NoResultException ex) {
            produtosRetorno = null;
            System.out.println("Erro ao procurar produtos por categoria: " + ex.getMessage());
        }
        return produtosRetorno;
    }
    

    public List<Produto>  findProdutosDisponiveis( Produto produto){
                EntityManager manager = JPAUtil.getEntityManager();
        
        List<Produto> produtoRetorno= new ArrayList<>();
        TypedQuery<Produto> query =  manager.createQuery( "SELECT p FROM Produto p WHERE p.nome LIKE :produto AND p NOT IN "
                + "                                    (SELECT s.produto FROM SolicitacaoAluguel s WHERE  s IN "
                + "                                    (SELECT a.solicitacaoAluguel FROM Aluguel a WHERE a.dataDevolucao IS NULL ) )", Produto.class);
       
        query.setParameter("produto", produto.getNome()+"%");
          
        try {
            produtoRetorno = query.getResultList();
        } catch(NoResultException ex){
            produtoRetorno = null;
        }  
       
        manager.close();
        
        return  produtoRetorno;

    }
    
    public List<Aluguel>  findAluguel(Condomino locatario){
        
        EntityManager manager = JPAUtil.getEntityManager();
        
        List<Aluguel> aluguelRetorno= new ArrayList<>();
        TypedQuery<Aluguel> query =  manager.createQuery( "SELECT a FROM Aluguel a WHERE a.dataDevolucao IS NULL AND a.solicitacaoAluguel.locatario = :locatario ", Aluguel.class);
        query.setParameter("locatario", locatario);
          
        try {
            aluguelRetorno = query.getResultList();
        } catch(NoResultException ex){
            aluguelRetorno = null;
        }  
       
        manager.close();
        
        return  aluguelRetorno;

    }
    
}