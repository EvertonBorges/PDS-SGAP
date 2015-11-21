package modelo;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comentario {
    @Id
    @GeneratedValue
    private Long codigo;
    private String comentario;
    
    @Enumerated
    private Avaliacao avaliacao;
    
    @Temporal(TemporalType.DATE)
    private Calendar dataComentario;
    
    @OneToOne (mappedBy = "comentario")
    private Aluguel aluguel;
    
    public Comentario() {
        
    }
    
    public Comentario(Calendar dataComentario, Long codigo, String comentario, Avaliacao avaliacao, Aluguel aluguel) {
        this.codigo = codigo;
        this.comentario = comentario;
        this.avaliacao=avaliacao;
        this.dataComentario=dataComentario;
        this.aluguel = aluguel;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }
  
    public Long getCodigo() {
        return codigo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return comentario;
    }

    public Calendar getDataComentario() {
        return dataComentario;
    }

    public void setDataComentario(Calendar dataComentario) {
        this.dataComentario = dataComentario;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }
 }