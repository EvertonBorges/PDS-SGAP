package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class ImagemProduto {
    @Id
    @GeneratedValue
    private Long codigo;
    @Lob
    private byte[] imagem;
    
    @ManyToOne
    private Produto produto;
    
    public ImagemProduto() {
    }

    public ImagemProduto(byte[] imagem, Produto produto) {
        this.imagem = imagem;
        this.produto = produto;
    }

    public Long getCodigo() {
        return codigo;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}