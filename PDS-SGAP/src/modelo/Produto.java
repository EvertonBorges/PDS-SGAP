package modelo;

import dao.AluguelDAO;
import java.util.ArrayList;
import java.util.List;
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
    
    @OneToMany (mappedBy = "produto", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)  
    @Fetch(FetchMode.SUBSELECT)
    private List<SolicitacaoAluguel> solicitacoes;
        
    @OneToMany (mappedBy = "produto", cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.EAGER)  
    @Fetch(FetchMode.SUBSELECT)
    private List<ImagemProduto> imagensProduto;
    
    @ManyToOne
    private Condomino condomino;
    
    @ManyToMany
    private List<Categoria> categorias;
    
    @Transient
    private double reputacao;
        
    public Produto() {
        imagensProduto = new ArrayList<>();
        categorias = new ArrayList<>();
    }

    public Produto(String nome) {
        this.nome = nome;
    }

    public Produto(String nome, String descricao, double diaria, int taxa ,List<ImagemProduto> imagensProduto, List<SolicitacaoAluguel> solicitacoes, Condomino condomino, List<Categoria> categorias) {
        this.nome = nome;
        this.descricao = descricao;
        this.diaria = diaria;
        this.taxa = taxa;
        this.imagensProduto = imagensProduto;
        this.condomino = condomino;
        this.categorias = categorias;
        this.solicitacoes=solicitacoes;
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
    
    public double getReputacao(){
        AluguelDAO aluguelDAO = new AluguelDAO();
        this.reputacao = aluguelDAO.calculaReputacao(this);
        return reputacao;
    }
}