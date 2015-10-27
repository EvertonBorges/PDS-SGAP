package modelo;

import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Condomino {
    @Id @GeneratedValue
    private Long codigo;
    private String nome;
    private String cpf;
    private String login;
    private String senha;
    
    @Temporal(TemporalType.DATE)
    private Calendar dataNascimento;
    
    private EstadoCivil estadoCivil;
    private List<String> telefones;
    private List<Apartamento> apartamentos;

    public Condomino() {
    }

    public Condomino(String nome, Calendar dataNascimento, String cpf, String login, String senha, EstadoCivil estadoCivil, List<String> telefones, List<Apartamento> apartamentos) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.estadoCivil = estadoCivil;
        this.telefones = telefones;
        this.apartamentos = apartamentos;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

    public List<Apartamento> getApartamentos() {
        return apartamentos;
    }

    public void setApartamentos(List<Apartamento> apartamentos) {
        this.apartamentos = apartamentos;
    }
}