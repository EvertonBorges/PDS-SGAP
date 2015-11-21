package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import modelo.Comentario;
import modelo.Produto;
import util.JPAUtil;

public class ComentarioDAO {
    
    public void addComentario(Comentario comentario){
        
    }
    
    public List<Comentario> findComentarios(Produto produto){
        List<Comentario> comentarios;
        EntityManager manager = JPAUtil.getEntityManager();
        TypedQuery<Comentario> query = manager.createQuery("SELECT c FROM Comentario c WHERE c.aluguel.solicitacaoAluguel.produto = :produto", Comentario.class);
        query.setParameter("produto", produto);
        query.setMaxResults(10);
        try{
            comentarios = query.getResultList();
        } catch(NoResultException ex){
            comentarios = null;
        }
        return comentarios;
    }
}
