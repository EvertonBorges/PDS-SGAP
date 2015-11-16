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
 * @author Borges
 */

@Entity
public class Alugado {
    @Id
    @GeneratedValue
    private Long codigo;
    
    
    private Condomino condomino;
    private SolicitacaoAluguel solicitacaoAluguel;

    public Alugado() {
    }

    public Alugado(Condomino condomino, SolicitacaoAluguel solicitacaoAluguel) {
        this.condomino = condomino;
        this.solicitacaoAluguel = solicitacaoAluguel;
    }

    public Long getCodigo() {
        return codigo;
    }

    public Condomino getCondomino() {
        return condomino;
    }

    public void setCondomino(Condomino condomino) {
        this.condomino = condomino;
    }

    public SolicitacaoAluguel getSolicitacaoAluguel() {
        return solicitacaoAluguel;
    }

    public void setSolicitacaoAluguel(SolicitacaoAluguel solicitacaoAluguel) {
        this.solicitacaoAluguel = solicitacaoAluguel;
    }
}