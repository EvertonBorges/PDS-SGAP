package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Apartamento {
    @Id
    @GeneratedValue
    private Long codigo;
    private char bloco;
    private int andar;
    private String numApartamento;
    
    @OneToMany (mappedBy = "apartamento")
    private List<Condomino> condominos;

    public Apartamento() {
        condominos = new ArrayList<>();
    }

    public Apartamento(char bloco, int andar, String numApartamento) {
        this.bloco = bloco;
        this.andar = andar;
        this.numApartamento = numApartamento;
    }

    public Long getCodigo() {
        return codigo;
    }

    public char getBloco() {
        return bloco;
    }

    public void setBloco(char bloco) {
        this.bloco = bloco;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public String getNumApartamento() {
        return numApartamento;
    }

    public void setNumApartamento(String numApartamento) {
        this.numApartamento = numApartamento;
    }

    public List<Condomino> getCondominos() {
        return condominos;
    }

    public void setCondominos(List<Condomino> condominos) {
        this.condominos = condominos;
    }

    @Override
    public String toString() {
        return "Bloco " + bloco + ", Andar "+ andar + ", numero apto " + numApartamento;
    }
}