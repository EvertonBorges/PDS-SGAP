/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Borges
 */

@Entity
public class Aluguel {
    @Id
    @GeneratedValue
    private Long codigo;
    
    @OneToOne //(cascade = CascadeType.ALL)
    private SolicitacaoAluguel solicitacaoAluguel;
    
    @Temporal (TemporalType.DATE)
    private Calendar dataDevolucao;

    public Aluguel() {
    }

    public Aluguel(SolicitacaoAluguel solicitacaoAluguel, Calendar dataDevolucao) {
        this.solicitacaoAluguel = solicitacaoAluguel;
        this.dataDevolucao = dataDevolucao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public Calendar getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Calendar dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public SolicitacaoAluguel getSolicitacaoAluguel() {
        return solicitacaoAluguel;
    }

    public void setSolicitacaoAluguel(SolicitacaoAluguel solicitacaoAluguel) {
        this.solicitacaoAluguel = solicitacaoAluguel;
    }
}