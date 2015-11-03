package modelo;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Condomino {
    @Id
    @GeneratedValue
    private Long codigo;
    private String nome;
    private String cpf;
    private String login;
    private String senha;
    
    @Temporal(TemporalType.DATE)
    private Calendar dataNascimento;
    
    @ManyToOne
    private Apartamento apartamento;
    
    @ManyToOne
    private EstadoCivil estadoCivil;
    
    @OneToMany (mappedBy = "condomino")
    private List<Produto> produtos;
    
    @ElementCollection
    private Collection<String> telefones;

    public Condomino() {
    }

    public Condomino(String nome, String cpf, String login, String senha, Calendar dataNascimento, Apartamento apartamento, EstadoCivil estadoCivil, Collection<String> telefones) {
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.apartamento = apartamento;
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

    public Collection<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Collection<String> telefones) {
        this.telefones = telefones;
    }

    public Apartamento getApartamento() {
        return apartamento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}