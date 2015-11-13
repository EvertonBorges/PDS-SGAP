package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import modelo.SolicitacaoAluguel;
import util.JPAUtil;

public class SolicitacaoAluguelDAO {
    private List<SolicitacaoAluguel> solicitacoes =  new ArrayList<>();
    
    public SolicitacaoAluguelDAO() {
        //preencherLista();
    }
    
    public void preencherLista(){
        this.solicitacoes.clear();
        EntityManager manager = JPAUtil.getEntityManager();
        Query query = manager.createQuery("SELECT s FROM Solicitacao s ");
        try{
            this.solicitacoes = query.getResultList();
        } catch (NoResultException ex) {
            this.solicitacoes = null;
            System.out.println("\nerro ao buscar solicitacao");
        }
    }
    
    public List<SolicitacaoAluguel> getProdutos() {
        return solicitacoes;
    }
    
    public void addSolicitacao(SolicitacaoAluguel solicitacao){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(solicitacao);

        manager.getTransaction().commit();
        manager.close();
        JOptionPane.showMessageDialog(null, "Solicitação realizada com sucesso", "Confirmacao ", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void alterSolicitacao(SolicitacaoAluguel solicitacaoNova){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();

        SolicitacaoAluguel solicitacao = manager.find(SolicitacaoAluguel.class, solicitacaoNova.getCodigo());
        solicitacao.setDataInicioAluguel(solicitacaoNova.getDataInicioAluguel());
        solicitacao.setDataSolicitacao(solicitacaoNova.getDataSolicitacao());
        solicitacao.setDiasPretendidos(solicitacaoNova.getDiasPretendidos());
        solicitacao.setLocatario(solicitacaoNova.getLocatario());
        solicitacao.setProduto(solicitacaoNova.getProduto());
        solicitacao.setQuantidade(solicitacaoNova.getQuantidade());
        
        manager.getTransaction().commit();
        manager.close();
        JOptionPane.showMessageDialog(null, "Solicitacao alterada com sucesso", "Solicitacao Alterado", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void removeSolicitacao(SolicitacaoAluguel solicitacao){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        SolicitacaoAluguel solicitacaoRemover = manager.find(SolicitacaoAluguel.class, solicitacao.getCodigo());
        
        manager.remove(solicitacaoRemover);
        manager.getTransaction().commit();
        manager.close();
        JOptionPane.showMessageDialog(null, "Solicitacao cancelada com sucesso", "Solicitacao cancelada", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /*
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
    
    public List<Produto> findProduto(boolean status, EntityManager manager){
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
    */
}