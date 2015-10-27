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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Borges
 */
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
    private Apartamento apartamentos;
    
    private EstadoCivil estadoCivil;
    private List<String> telefones;
    

    public Condomino() {
    }

    public Condomino(String nome, String cpf, String login, String senha, Calendar dataNascimento, Apartamento apartamentos, EstadoCivil estadoCivil, List<String> telefones) {
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.apartamentos = apartamentos;
        this.estadoCivil = estadoCivil;
        this.telefones = telefones;
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

    public Apartamento getApartamentos() {
        return apartamentos;
    }

    public void setApartamentos(Apartamento apartamentos) {
        this.apartamentos = apartamentos;
    }
}