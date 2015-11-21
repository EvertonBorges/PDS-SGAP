package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Produto {
    @Id
    @GeneratedValue
    private Long codigo;
    private String nome;
    private String descricao;
    private double diaria;
    private double taxa;
    private boolean status;
    
    @Transient
    private double reputacao;
    
    @OneToMany (mappedBy = "produto", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)  
    @Fetch(FetchMode.SUBSELECT)
    private List<SolicitacaoAluguel> solicitacoes;
        
    @OneToMany (mappedBy = "produto", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)  
    @Fetch(FetchMode.SUBSELECT)
    private List<ImagemProduto> imagensProduto;
    
    @ManyToOne
    private Condomino condomino;
    
    @ManyToMany
    private List<Categoria> categorias;
    
    @OneToMany (mappedBy= "produto", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)  
    @Fetch(FetchMode.SUBSELECT)
    private List<Comentario> comentarios;
    
    
    
    public Produto() {
        imagensProduto = new ArrayList<>();
        categorias = new ArrayList<>();
        comentarios = new ArrayList<>();
    }

    public Produto(String nome, String descricao, double diaria, int taxa ,List<ImagemProduto> imagensProduto, List<SolicitacaoAluguel> solicitacoes, Condomino condomino, List<Categoria> categorias, List<Comentario> comentarios ) {
        this.nome = nome;
        this.descricao = descricao;
        this.diaria = diaria;
        this.taxa = taxa;
        this.imagensProduto = imagensProduto;
        this.condomino = condomino;
        this.categorias = categorias;
        this.comentarios=comentarios;
        this.solicitacoes=solicitacoes;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Condomino getCondomino() {
        return condomino;
    }

    public void setCondomino(Condomino condomino) {
        this.condomino = condomino;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public double getDiaria() {
        return diaria;
    }

    public void setDiaria(double diaria) {
        this.diaria = diaria;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public List<ImagemProduto> getImagensProduto() {
        return imagensProduto;
    }

    public void setImagensProduto(List<ImagemProduto> imagensProduto) {
        this.imagensProduto = imagensProduto;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
    public List<SolicitacaoAluguel> getSolicitacoes() {
        return solicitacoes;
    }

    public void setSolicitacoes(List<SolicitacaoAluguel> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }
    
    @Override
    public String toString() {
        return nome;
    }
    public String getReputacao(){
        calcularReputacao();
        if (reputacao==200)
            return "NOVO";
        else{
            String valor = ""+reputacao;
            valor=(valor.substring(valor.length()-1));
            if (valor.equals("0")){
                return Math.round(reputacao)+"%";
            }
            return reputacao+"%";
        }
    }
    
    public void calcularReputacao(){
        
        double positiva=0, regular=0;
        if(comentarios.size()>0){
            for (Comentario comentario : comentarios) {
                if (comentario.getAvaliacao().getCodigo()==1) {
                    positiva++;
                }
                if (comentario.getAvaliacao().getCodigo()==2) {
                    regular++;
                }
            }
            reputacao = Double.valueOf(String.format(Locale.US, "%.1f", ((positiva/comentarios.size()) + ((regular/2)/comentarios.size()))*100));
        }
        else{
            reputacao=200;
        }
    }
}