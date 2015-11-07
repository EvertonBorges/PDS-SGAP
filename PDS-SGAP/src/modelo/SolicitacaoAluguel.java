/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author LAB
 */
@Entity
public class SolicitacaoAluguel {
    
    @Id
    @GeneratedValue
    private Long codigo;
    
    @ManyToOne
    private Produto produto;
    
    @OneToMany (mappedBy = "solicitacao")
    private List<Condomino> locatario;
    
    @Temporal (TemporalType.DATE)
    private Calendar dataSolicitacao;
    @Temporal (TemporalType.DATE)
    private Calendar dataInicioAluguel;
    
    private int diasPretendidos;
    private int quantidade;

    public SolicitacaoAluguel() {
    }

    public SolicitacaoAluguel(Produto produto, List<Condomino> locatario, Calendar dataSolicitacao, Calendar dataInicioAluguel, int diasPretendidos, int quantidade) {
        this.produto = produto;
        this.locatario = locatario;
        this.dataSolicitacao = dataSolicitacao;
        this.dataInicioAluguel = dataInicioAluguel;
        this.diasPretendidos = diasPretendidos;
        this.quantidade = quantidade;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Condomino> getLocatario() {
        return locatario;
    }

    public void setLocatario(List<Condomino> locatario) {
        this.locatario = locatario;
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
        return dataSolicitacao + "  " + produto + " " + locatario ;
    }    
}