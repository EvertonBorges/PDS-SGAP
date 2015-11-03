package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categoria {
    @Id
    @GeneratedValue
    private Long codigo;
    private String descricao;
    
    public Categoria() {
        
    }

    public Categoria(String descricao) {
        this.descricao = descricao;
    }

    
    public Long getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}