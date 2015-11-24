package modelo;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class SolicitacaoAluguel {
    @Id
    @GeneratedValue
    private Long codigo;
    private int diasPretendidos;
    
    @ManyToOne
    private Produto produto;
    
    @ManyToOne
    private Condomino locatario;
    
    @Temporal (TemporalType.DATE)
    private Calendar dataSolicitacao;
    @Temporal (TemporalType.DATE)
    private Calendar dataInicioAluguel;
    
    @Transient
    private Calendar dataPrevista;
    
    public SolicitacaoAluguel() {
        
    }
    
    public SolicitacaoAluguel(int diasPretendidos, Produto produto, Condomino locatario, Calendar dataSolicitacao, Calendar dataInicioAluguel) {
        this.diasPretendidos = diasPretendidos;
        this.produto = produto;
        this.locatario = locatario;
        this.dataSolicitacao = dataSolicitacao;
        this.dataInicioAluguel = dataInicioAluguel;
    }

    public Long getCodigo() {
        return codigo;
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

    public Calendar getDataPrevista() {
        dataPrevista = Calendar.getInstance();
        this.dataPrevista.set(Calendar.DAY_OF_YEAR, dataInicioAluguel.get(Calendar.DAY_OF_YEAR));
        this.dataPrevista.add(Calendar.DAY_OF_YEAR, diasPretendidos);
        return dataPrevista;
    }

    @Override
    public String toString() {
        return dataSolicitacao + "  " + produto + " " + locatario ;
    }
}