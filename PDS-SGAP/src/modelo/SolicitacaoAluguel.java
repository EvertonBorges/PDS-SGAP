/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Calendar;

/**
 *
 * @author LAB
 */
public class SolicitacaoAluguel {
    
    private Produto produto;
    private Condomino locatario;
    private Condomino locador;
    private Calendar dataSolicitacao;
    private Calendar dataInicioAluguel;
    private int diasPretendidos;
    private int quantidade;

    public SolicitacaoAluguel() {
    }

    public SolicitacaoAluguel(Produto produto, Condomino locatario, Condomino locador, Calendar dataSolicitacao, Calendar dataInicioAluguel, int diasPretendidos, int quantidade) {
        this.produto = produto;
        this.locatario = locatario;
        this.locador = locador;
        this.dataSolicitacao = dataSolicitacao;
        this.dataInicioAluguel = dataInicioAluguel;
        this.diasPretendidos = diasPretendidos;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Condomino getLocatario() {
        return locatario;
    }

    public void setLocatario(Condomino locatario) {
        this.locatario = locatario;
    }

    public Condomino getLocador() {
        return locador;
    }

    public void setLocador(Condomino locador) {
        this.locador = locador;
    }

    public Calendar getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Calendar dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Calendar getDataInicioAluguel() {
        return dataInicioAluguel;
    }

    public void setDataInicioAluguel(Calendar dataInicioAluguel) {
        this.dataInicioAluguel = dataInicioAluguel;
    }

    public int getDiasPretendidos() {
        return diasPretendidos;
    }

    public void setDiasPretendidos(int diasPretendidos) {
        this.diasPretendidos = diasPretendidos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return dataSolicitacao+"  "+ produto + " " + locatario ;
    }
    
    
    
    
    
    
}
