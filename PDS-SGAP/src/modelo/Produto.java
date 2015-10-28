package modelo;

import java.util.Collection;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Produto {
    @Id
    @GeneratedValue
    private Long codigo;
    private String nome;
    private String descricao;
    private int quantidade;
    private double diaria;
    private int taxa;
    
    @Lob
    @ElementCollection
    private Collection<byte[]> imagens;
    
    @ManyToOne
    private Condomino condomino;
    @ManyToMany (mappedBy = "produtos")
    private List<Categoria> categorias;
    
    public Produto() {
        
    }

    public Produto(String nome, String descricao, int quantidade, double diaria, int taxa, Collection<byte[]> imagens, Condomino condomino, List<Categoria> categorias) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.diaria = diaria;
        this.taxa = taxa;
        this.imagens = imagens;
        this.condomino = condomino;
        this.categorias = categorias;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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

    public Collection<byte[]> getImagens() {
        return imagens;
    }

    public void setImagens(Collection<byte[]> imagens) {
        this.imagens = imagens;
    }

    public double getDiaria() {
        return diaria;
    }

    public void setDiaria(double diaria) {
        this.diaria = diaria;
    }

    public int getTaxa() {
        return taxa;
    }

    public void setTaxa(int taxa) {
        this.taxa = taxa;
    }
}