/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Ada
 */
@Entity
public class Avaliacao {
    
    @Id
    @GeneratedValue
    private Long codigo;
    private String avaliacao;

    public Avaliacao() {
    }

    public Avaliacao(Long codigo, String avaliacao) {
        this.codigo = codigo;
        this.avaliacao = avaliacao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return avaliacao;
    }
}