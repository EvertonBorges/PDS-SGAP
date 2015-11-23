package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import modelo.Condomino;
import modelo.Produto;
import modelo.SolicitacaoAluguel;
import util.JPAUtil;

public class SolicitacaoAluguelDAO {
    
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
    }
    
    public void removeSolicitacao(SolicitacaoAluguel solicitacao){
        EntityManager manager = JPAUtil.getEntityManager();
        
        SolicitacaoAluguel solicitacaoExcluir;
        manager.getTransaction().begin();      
        
        solicitacaoExcluir = manager.find(SolicitacaoAluguel.class, solicitacao.getCodigo());        
        manager.remove(solicitacaoExcluir);
        
        manager.getTransaction().commit();
        manager.close();
    }
    
    public List<Produto> findProdutos(Produto produtoPesquisa){
        EntityManager manager = JPAUtil.getEntityManager();
        List<Produto> produtosRetorno;
        Query query = manager.createNativeQuery("CALL SP_PRODUTOS_SOLICITADOS(:codigoDono, :nomeProduto)");
        query.setParameter("codigoDono", produtoPesquisa.getCondomino().getCodigo());
        query.setParameter("nomeProduto", produtoPesquisa.getNome() + "%");
        try{
            Object objeto = query.getSingleResult();
            Query queryProduto = manager.createNativeQuery(objeto.toString(), Produto.class);
            produtosRetorno = queryProduto.getResultList();
        } catch (NoResultException ex) {
            produtosRetorno = null;
        }
        manager.close();
        return produtosRetorno;
    }
    
    
    public List<Produto>  findProdutos(Condomino locatario, Produto produto){
        Calendar dataAtualCalendar = Calendar.getInstance();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        
        EntityManager manager = JPAUtil.getEntityManager();
        
        List<Produto> produtoRetorno= new ArrayList<>();
        TypedQuery<Produto> query =  manager.createQuery( "SELECT p FROM Produto p WHERE p.nome LIKE :produto AND p IN "
                + "                                       (SELECT s.produto FROM SolicitacaoAluguel s WHERE  s.locatario = :locatario)", Produto.class);
       
        query.setParameter("locatario", locatario);
        query.setParameter("produto", produto.getNome()+"%");
    
        try {
            produtoRetorno = query.getResultList();
        } catch(NoResultException ex){
            produtoRetorno = null;
        }  
       
        manager.close();
        
        return  produtoRetorno;

    }

    public List<SolicitacaoAluguel>  findSolicitacoes(Condomino locatario, Produto produto){
        Calendar dataAtualCalendar = Calendar.getInstance();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        
        EntityManager manager = JPAUtil.getEntityManager();
        
        List<SolicitacaoAluguel> solicitacoesRetorno= new ArrayList<>();
        TypedQuery<SolicitacaoAluguel> query =  manager.createQuery( "SELECT s FROM SolicitacaoAluguel s WHERE s.produto = :produto "
                + "                                                   AND s.locatario = :locatario", SolicitacaoAluguel.class);
       
        query.setParameter("locatario", locatario);
        query.setParameter("produto", produto);
          
        try {
            solicitacoesRetorno = query.getResultList();
        } catch(NoResultException ex){
            solicitacoesRetorno = null;
        }  
       
        manager.close();
        
        return  solicitacoesRetorno;

    }    
    


    public List<SolicitacaoAluguel> findSolicitacoes(Produto produtoPesquisa){
        EntityManager manager = JPAUtil.getEntityManager();
        List<SolicitacaoAluguel> solicitacoesRetorno;
        Query query = manager.createNativeQuery("CALL SP_SOLICITACOES_PRODUTO(:codigoProduto)", SolicitacaoAluguel.class);
        query.setParameter("codigoProduto", produtoPesquisa.getCodigo());
        try {
            solicitacoesRetorno = query.getResultList();
        } catch(NoResultException ex){
            solicitacoesRetorno = null;
        }
        manager.close();
        return solicitacoesRetorno;
    }
    
    public List<SolicitacaoAluguel>  findSolicitacaoProdutoEmAndamento(Condomino locatario, Produto produto){
        Calendar dataAtualCalendar = Calendar.getInstance();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        String dataAtualString = formatador.format(dataAtualCalendar.getTime());
        
        EntityManager manager = JPAUtil.getEntityManager();
        
        List<SolicitacaoAluguel> solicitacoesRetorno= new ArrayList<>();
        TypedQuery<SolicitacaoAluguel> query =  manager.createQuery( "SELECT s FROM SolicitacaoAluguel s WHERE s.locatario = :locatario AND s.produto = :produto AND s IN "
                + "                                                  (SELECT a.solicitacaoAluguel FROM Aluguel a WHERE a.dataDevolucao IS NULL )", SolicitacaoAluguel.class);
       
        query.setParameter("locatario", locatario);
        query.setParameter("produto", produto);
          
        try {
            solicitacoesRetorno = query.getResultList();
        } catch(NoResultException ex){
            solicitacoesRetorno = null;
        }  
       
        manager.close();
        
        return  solicitacoesRetorno;

    }
    

    public List<Produto>  findProdutoSolicitacaoEmAndamento(Condomino locatario, Produto produto){
        Calendar dataAtualCalendar = Calendar.getInstance();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        
        EntityManager manager = JPAUtil.getEntityManager();
        
        List<Produto> produtoRetorno= new ArrayList<>();
        TypedQuery<Produto> query =  manager.createQuery( "SELECT p FROM Produto p WHERE p.nome LIKE :produto AND p IN "
                + "                                    (SELECT s.produto FROM SolicitacaoAluguel s WHERE s.locatario = :locatario AND s IN "
                + "                                    (SELECT a.solicitacaoAluguel FROM Aluguel a WHERE a.dataDevolucao IS NULL ) )", Produto.class);
       
        query.setParameter("locatario", locatario);
        query.setParameter("produto", produto.getNome()+"%");
          
        try {
            produtoRetorno = query.getResultList();
        } catch(NoResultException ex){
            produtoRetorno = null;
        }  
       
        manager.close();
        
        return  produtoRetorno;

    }
     
    public List<SolicitacaoAluguel>  findSolicitacaoProdutoEmAvaliacao(Condomino locatario, Produto produto){
        Calendar dataAtualCalendar = Calendar.getInstance();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        
        EntityManager manager = JPAUtil.getEntityManager();
        
        List<SolicitacaoAluguel> solicitacoesRetorno= new ArrayList<>();
        TypedQuery<SolicitacaoAluguel> query =  manager.createQuery( "SELECT s FROM SolicitacaoAluguel s WHERE s.produto = :produto AND s.dataInicioAluguel >= :dataAtual AND s NOT IN "
                + "                                                  (SELECT a.solicitacaoAluguel FROM Aluguel a WHERE a.dataDevolucao IS NULL )"
                + "                                                  AND s.locatario = :locatario", SolicitacaoAluguel.class);
       
        query.setParameter("locatario", locatario);
        query.setParameter("produto", produto);
        query.setParameter("dataAtual", dataAtualCalendar);
    
        try {
            solicitacoesRetorno = query.getResultList();
        } catch(NoResultException ex){
            solicitacoesRetorno = null;
        }  
       
        manager.close();
        
        return  solicitacoesRetorno;

    }
    

    public List<Produto>  findProdutoSolicitacaoEmAvaliacao(Condomino locatario, Produto produto){
        Calendar dataAtualCalendar = Calendar.getInstance();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        String dataAtualString = formatador.format(dataAtualCalendar.getTime());
        
        EntityManager manager = JPAUtil.getEntityManager();
        
        List<Produto> produtoRetorno= new ArrayList<>();
        
       TypedQuery<Produto> query =  manager.createQuery( "SELECT p FROM Produto p WHERE p.nome LIKE :produto AND p IN "
                + "                                    (SELECT s.produto FROM SolicitacaoAluguel s WHERE s.dataInicioAluguel >= :dataAtual AND s NOT IN "
                + "                                    (SELECT a.solicitacaoAluguel FROM Aluguel a WHERE a.dataDevolucao IS NULL )"
                + "                                     AND s.locatario = :locatario)", Produto.class);
 
       
        query.setParameter("locatario", locatario);
        query.setParameter("produto", produto.getNome()+"%");
        query.setParameter("dataAtual", dataAtualCalendar);
          
        try {
            produtoRetorno = query.getResultList();
        } catch(NoResultException ex){
            produtoRetorno = null;
        }  
       
        manager.close();
        
        return  produtoRetorno;

    }

    
    public List<SolicitacaoAluguel>  findSolicitacaoProdutoExpiradas(Condomino locatario, Produto produto){
        Calendar dataAtualCalendar = Calendar.getInstance();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        
        EntityManager manager = JPAUtil.getEntityManager();
        
        List<SolicitacaoAluguel> solicitacoesRetorno= new ArrayList<>();
        TypedQuery<SolicitacaoAluguel> query =  manager.createQuery( "SELECT s FROM SolicitacaoAluguel s WHERE s.produto = :produto AND s.dataInicioAluguel < :dataAtual AND s NOT IN "
                + "                                                   (SELECT a.solicitacaoAluguel FROM Aluguel a WHERE a.dataDevolucao IS NULL ) "
                + "                                                    AND s.locatario = :locatario", SolicitacaoAluguel.class);
       
        query.setParameter("locatario", locatario);
        query.setParameter("produto", produto);
        query.setParameter("dataAtual", dataAtualCalendar);

        try {
            solicitacoesRetorno = query.getResultList();
        } catch(NoResultException ex){
            solicitacoesRetorno = null;
        }  
       
        manager.close();
        
        return  solicitacoesRetorno;

    }
    

    public List<Produto>  findProdutoSolicitacaoExpiradas(Condomino locatario, Produto produto){
        Calendar dataAtualCalendar = Calendar.getInstance();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        
        EntityManager manager = JPAUtil.getEntityManager();
        
        List<Produto> produtoRetorno= new ArrayList<>();
        
       TypedQuery<Produto> query =  manager.createQuery( "SELECT p FROM Produto p WHERE p.nome LIKE :produto AND p IN "
                + "                                     (SELECT s.produto FROM SolicitacaoAluguel s WHERE s.dataInicioAluguel < :dataAtual AND s NOT IN "
                + "                                     (SELECT a.solicitacaoAluguel FROM Aluguel a WHERE a.dataDevolucao IS NULL ) AND s.locatario = :locatario)", Produto.class);
 
       
        query.setParameter("locatario", locatario);
        query.setParameter("produto", produto.getNome()+"%");
        query.setParameter("dataAtual", dataAtualCalendar);       
        try {
            produtoRetorno = query.getResultList();
        } catch(NoResultException ex){
            produtoRetorno = null;
        }  
       
        manager.close();
        
        return  produtoRetorno;

    }

  public List<Produto>  findProdutoSolicitacaoAvaliar(Produto produto){
        Calendar dataAtualCalendar = Calendar.getInstance();
        
        EntityManager manager = JPAUtil.getEntityManager();
        
        List<Produto> produtoRetorno= new ArrayList<>();
        
       TypedQuery<Produto> query =  manager.createQuery( "SELECT p FROM Produto p WHERE p.condomino = :condomino AND p.nome LIKE :produto AND p IN "
                + "                                     (SELECT s.produto FROM SolicitacaoAluguel s WHERE s.dataInicioAluguel >= :dataAtual AND s NOT IN "
                + "                                     (SELECT a.solicitacaoAluguel FROM Aluguel a WHERE a.dataDevolucao IS NULL ))", Produto.class);
 
       
        query.setParameter("condomino", produto.getCondomino());
        query.setParameter("produto", produto.getNome()+"%");
        query.setParameter("dataAtual", dataAtualCalendar);
   
        try {
            produtoRetorno = query.getResultList();
        } catch(NoResultException ex){
            produtoRetorno = null;
        }  
       
        manager.close();
        
        return  produtoRetorno;

    }
    
    public List<SolicitacaoAluguel> findSolicitacoes(Calendar calendarInicio){
        List<SolicitacaoAluguel> solicitacoesAlugueis;
        EntityManager manager = JPAUtil.getEntityManager();
        TypedQuery<SolicitacaoAluguel> query = manager.createQuery("SELECT s FROM SolicitacaoAluguel s WHERE s.dataInicioAluguel >= :data", SolicitacaoAluguel.class);
        query.setParameter("data", calendarInicio);
        
        try {
            solicitacoesAlugueis = query.getResultList();
        } catch (NoResultException e) {
            solicitacoesAlugueis = null;
        }
        
        return solicitacoesAlugueis;
    }
    
    public List<SolicitacaoAluguel> findSolicitacaoEmAvaliacao(Condomino condomino, String nomeProduto){ // busca solicitacoes de um locatario que ainda não foram confirmadas
        EntityManager manager = JPAUtil.getEntityManager();
        List<SolicitacaoAluguel> solicitacoesRetorno;
        
        try{
            String consulta = "CALL SP_SOLICITACOES_CONFIRMACAO(:codigo, :produto)";
            Query query = manager.createNativeQuery(consulta, SolicitacaoAluguel.class);
            query.setParameter("codigo", condomino.getCodigo());
            query.setParameter("produto", nomeProduto);
            
            solicitacoesRetorno = query.getResultList();
        } catch (NoResultException ex) {
            solicitacoesRetorno = null;
        }
        manager.close();
        return solicitacoesRetorno;
    }
}