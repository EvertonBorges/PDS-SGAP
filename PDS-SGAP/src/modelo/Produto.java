package modelo;

import java.awt.Image;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto {
    @Id
    @GeneratedValue
    private Long codigo;
    private String nome;
    private String descricao;
    private int quantidade;
    
    private List<Image> imagens;

    public Produto() {
    }

    public Produto(String nome, String descricao, int quantidade, List<Image> imagens) {
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

    public List<Image> getImagens() {
        return imagens;
    }

    public void setImagens(List<Image> imagens) {
        this.imagens = imagens;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
