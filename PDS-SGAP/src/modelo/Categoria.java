package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Categoria {
    @Id
    @GeneratedValue
    private Long codigo;
    private String descricao;

    @ManyToMany (mappedBy = "categorias")
    private List<Produto> produtos;
    
    public Categoria() {
        produtos = new ArrayList<>();
    }

    public Categoria(String descricao) {
        this.descricao = descricao;
        produtos = new ArrayList<>();
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}