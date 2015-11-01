/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ada
 */
@Entity
public class Comentario {
    
    @Id
    @GeneratedValue
    private Long codigo;
    private String comentario;
    private Calendar data;
    
    @ManyToOne
    @JoinColumn (name= "produto_codigo")
    private Produto produto;
    
    
    @ManyToOne
    @JoinColumn (name= "comentarista_codigo")
    private Condomino comentarista;
    
    @ManyToOne
    @JoinColumn (name= "avaliacao_codigo")
    private Avaliacao avaliacao;

    public Comentario() {
        
    }
    
    public Comentario(Calendar data, Long codigo, String comentario, Produto produto, Condomino comentarista, Avaliacao avaliacao) {
        this.codigo = codigo;
        this.comentario = comentario;
        this.produto = produto;
        this.comentarista=comentarista;
        this.avaliacao=avaliacao;
        this.data=data;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }
    

    public Condomino getComentarista() {
        return comentarista;
    }

    public void setComentarista(Condomino comentarista) {
        this.comentarista = comentarista;
    }

  
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return comentario;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
    
    
    
 }