package dao;

import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import modelo.Aluguel;
import modelo.Condomino;
import modelo.ImagemProduto;
import modelo.Produto;
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
        Query query = manager.createQuery("SELECT s FROM SolicitacaoAluguel s");
        try{
            this.solicitacoes = query.getResultList();
        } catch (NoResultException ex) {
            this.solicitacoes = null;
            System.out.println("Erro ao buscar solicitacao");
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
    }
    
    public void alterSolicitacao(SolicitacaoAluguel solicitacaoNova){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(solicitacaoNova);
        manager.getTransaction().commit();
        manager.close();
        JOptionPane.showMessageDialog(null, "Solicitacao alterada com sucesso", "Solicitacao Alterado", JOptionPane.INFORMATION_MESSAGE);
        
        /*
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
        */
    }
    
    public void removeSolicitacao(SolicitacaoAluguel solicitacao){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        SolicitacaoAluguel solicitacaoRemover = manager.find(SolicitacaoAluguel.class, solicitacao.getCodigo());
        AluguelDAO aDAO = new AluguelDAO();
        List<Aluguel> alugueis = aDAO.getAlugueis();
        TypedQuery<Aluguel> query =  manager.createQuery("SELECT a FROM Aluguel azz WHERE a.solicitacaoAluguel.codigo = :solicitacao ",Aluguel.class);
        query.setParameter("solicitacao", solicitacao.getCodigo());
        
        try{
            alugueis = query.getResultList();
        } catch (NoResultException ex) {
            alugueis = null;
        }
        if(alugueis != null && !alugueis.isEmpty()){
           // aDAO.removeAluguel();
            manager.remove(manager.getReference(Aluguel.class, alugueis.get(0).getCodigo()));

        }
        manager.remove(solicitacaoRemover);
        manager.getTransaction().commit();
        manager.close();
        JOptionPane.showMessageDialog(null, "Solicitacao cancelada com sucesso", "Solicitacao cancelada", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public List<Produto> findProdutos(Produto produtoPesquisa){
        Calendar dataAtualCalendar = Calendar.getInstance();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        String dataAtualString = formatador.format(dataAtualCalendar.getTime());
        EntityManager manager = JPAUtil.getEntityManager();
        List<Produto> produtosRetorno;
        Query query = manager.createNativeQuery("CALL SP_PRODUTOS_SOLICITADOS(:codigoDono, :nomeProduto, :dataAtual)", Produto.class);
        query.setParameter("codigoDono", produtoPesquisa.getCondomino().getCodigo());
        query.setParameter("nomeProduto", produtoPesquisa.getNome() + "%");
        query.setParameter("dataAtual", dataAtualString);
        try{
            produtosRetorno = query.getResultList();
        } catch (NoResultException ex) {
            produtosRetorno = null;
        }
        manager.close();
        return produtosRetorno;
    }
    
    public List<Produto> findProdutos(Produto produtoPesquisa, Condomino locatario){
        Calendar dataAtualCalendar = Calendar.getInstance();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        String dataAtualString = formatador.format(dataAtualCalendar.getTime());
        EntityManager manager = JPAUtil.getEntityManager();
        List<Produto> produtosRetorno;
        Query query = manager.createNativeQuery("CALL SP_PRODUTOS_SOLICITADOS_LOCATARIO(:codigoLocatario, :nomeProduto)", Produto.class);
        query.setParameter("codigoLocatario", locatario.getCodigo());
        query.setParameter("nomeProduto", produtoPesquisa.getNome() + "%");
        try{
            produtosRetorno = query.getResultList();
        } catch (NoResultException ex) {
            produtosRetorno = null;
        }
        manager.close();
        return produtosRetorno;
    }
    

    public List<SolicitacaoAluguel> findSolicitacoes(Produto produtoPesquisa){
        Calendar dataAtualCalendar = Calendar.getInstance();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        String dataAtualString = formatador.format(dataAtualCalendar.getTime());
        EntityManager manager = JPAUtil.getEntityManager();
        List<SolicitacaoAluguel> solicitacoesRetorno;
        Query query = manager.createNativeQuery("CALL SP_SOLICITACOES_PRODUTO(:codigoProduto, :dataAtual)", SolicitacaoAluguel.class);
        query.setParameter("codigoProduto", produtoPesquisa.getCodigo());
        query.setParameter("dataAtual", dataAtualString);
        try {
            solicitacoesRetorno = query.getResultList();
        } catch(NoResultException ex){
            solicitacoesRetorno = null;
        }
        manager.close();
        return solicitacoesRetorno;
    }
    
    public List<SolicitacaoAluguel> findSolicitacoes(Produto produtoPesquisa, Condomino locatario){
        Calendar dataAtualCalendar = Calendar.getInstance();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        String dataAtualString = formatador.format(dataAtualCalendar.getTime());
        EntityManager manager = JPAUtil.getEntityManager();
        List<SolicitacaoAluguel> solicitacoesRetorno;
        Query query = manager.createNativeQuery("CALL SP_SOLICITACOES_PRODUTO_LOCATARIO(:codigoProduto, :codigoLocatario)", SolicitacaoAluguel.class);
        query.setParameter("codigoProduto", produtoPesquisa.getCodigo());
        query.setParameter("codigoLocatario", locatario.getCodigo());
        try {
            solicitacoesRetorno = query.getResultList();
        } catch(NoResultException ex){
            solicitacoesRetorno = null;
        }
        manager.close();
        return solicitacoesRetorno;
    }
    
/*    public List<SolicitacaoAluguel>  findSolicitacaoEmAndamento(Condomino locatario, Produto produto){
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        List<SolicitacaoAluguel> solicitacoesRetorno= new ArrayList<>();
        TypedQuery<Aluguel> query =  manager.createQuery("SELECT a FROM Aluguel a WHERE a.solicitacaoAluguel.locatario = :locatario AND a.solicitacaoAluguel.produto = :produto", Aluguel.class);
        query.setParameter("locatario", locatario);
        query.setParameter("produto", produto);
        List<Aluguel> alugueis = new ArrayList<>();
        try {
            alugueis = query.getResultList();
        } catch(NoResultException ex){
            alugueis = null;
        }   
        for (Aluguel s: alugueis){
            solicitacoesRetorno.add(s.getSolicitacaoAluguel());
        }
        
        manager.close();
        
        return  solicitacoesRetorno;

    }*/
    
    public List<Produto>  findProdutoSolicitacaoEmAndamento(Condomino locatario, Produto produto){
        Calendar dataAtualCalendar = Calendar.getInstance();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        String dataAtualString = formatador.format(dataAtualCalendar.getTime());
        
        EntityManager manager = JPAUtil.getEntityManager();
        
        List<Produto> produtoRetorno= new ArrayList<>();
        Query query = manager.createNativeQuery("CALL SP_PRODUTOS_SOLICITADOS_EM_ANDAMENTO( :locatario, :produto , :dataAtual)", Produto.class);
        query.setParameter("locatario", locatario.getCodigo());
        query.setParameter("produto", produto.getNome()+"%");
        query.setParameter("dataAtual", dataAtualString);
        //List<Aluguel> alugueis ;
        System.out.println("LOCATARIO:"+locatario.getCodigo());
        System.out.println("PRODUTO:"+produto.getCodigo());
        System.out.println("DATA ATUAL:"+dataAtualString);
          
        try {
            produtoRetorno = query.getResultList();
        } catch(NoResultException ex){
            produtoRetorno = null;
        }  
       
        manager.close();
        
        return  produtoRetorno;

    }
       
    /*
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