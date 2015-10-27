package modelo;

import java.util.Collection;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Produto {
    @Id
    @GeneratedValue
    private Long codigo;
    private String nome;
    private String descricao;
    private int quantidade;
    
    @ElementCollection
    private Collection<String> imagens;
    
    @ManyToOne
    private Condomino condomino;
    @OneToMany (mappedBy = "categoria")
    private List<Categoria> categorias;
    
    public Produto() {
        
    }

    public Produto(String nome, String descricao, int quantidade, Collection<String> imagens) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.imagens = imagens;
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

    public Collection<String> getImagens() {
        return imagens;
    }

    public void setImagens(Collection<String> imagens) {
        this.imagens = imagens;
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
}