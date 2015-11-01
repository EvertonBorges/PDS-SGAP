package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
    private double diaria;
    private int taxa;
    private boolean status;

    @OneToMany (mappedBy = "produto")
    private List<ImagemProduto> imagensProduto;
    
    @ManyToOne
    @JoinColumn (name= "condomino_codigo")
    private Condomino condomino;
    
    @ManyToMany(mappedBy = "produtos")
    private List<Categoria> categorias;
        
    @OneToMany (mappedBy= "produto")
    private List <Comentario> comentarios;
    
    public Produto() {
        comentarios= new ArrayList<>();
        categorias= new ArrayList<>();
        imagensProduto= new ArrayList<>();
    }

    public Produto(String nome, String descricao, int quantidade, double diaria, int taxa ,List<ImagemProduto> imagensProduto, Condomino condomino, List<Categoria> categorias, List<Comentario> comentarios ) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.diaria = diaria;
        this.taxa = taxa;
        this.imagensProduto = imagensProduto;
        this.condomino = condomino;
        this.categorias = categorias;
        this.comentarios=comentarios;
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
    
}