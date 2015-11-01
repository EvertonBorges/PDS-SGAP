/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 *
 * @author Everton Soares
 */
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