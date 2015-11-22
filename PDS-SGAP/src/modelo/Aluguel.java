package modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Aluguel {
    @Id
    @GeneratedValue
    private Long codigo;
    
    @OneToOne //(cascade = CascadeType.ALL)
    @JoinColumn (unique = true)
    private SolicitacaoAluguel solicitacaoAluguel;
    
    @OneToOne (mappedBy = "aluguel")
    private Comentario comentario;
    
    @Temporal (TemporalType.DATE)
    private Calendar dataDevolucao;

    @Temporal(TemporalType.DATE)
    @Transient
    private Calendar dataVencimento;

    public Aluguel() {
    }

    public Aluguel(SolicitacaoAluguel solicitacaoAluguel, Calendar dataDevolucao, Comentario comentario) {
        this.solicitacaoAluguel = solicitacaoAluguel;
        this.dataDevolucao = dataDevolucao;
        this.comentario = comentario;
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

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }
    
    public Calendar getDataVencimento() {
        this.dataVencimento = new GregorianCalendar(this.solicitacaoAluguel.getDataInicioAluguel().get(Calendar.YEAR), 
                                                    this.solicitacaoAluguel.getDataInicioAluguel().get(Calendar.MONTH), 
                                                    this.solicitacaoAluguel.getDataInicioAluguel().get(Calendar.DAY_OF_MONTH));
        this.dataVencimento.add(Calendar.DAY_OF_MONTH, +this.solicitacaoAluguel.getDiasPretendidos()); // adicionan n dias a esta data
        
        return this.dataVencimento;
    }
}