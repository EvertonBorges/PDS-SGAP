package modelo;

import dao.AluguelDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Condomino {
    @Id
    @GeneratedValue
    private Long codigo;
    private String nome;
    private String cpf;
    private String login;
    private String senha;
    
    @Enumerated
    private TipoUsuario tipoUsuario;
    
    @Temporal(TemporalType.DATE)
    private Calendar dataNascimento;
    
    @OneToMany (mappedBy = "locatario")
    private List<SolicitacaoAluguel> solicitacoes;
    
    @ManyToOne
    private Apartamento apartamento;
    
    @ManyToOne
    private EstadoCivil estadoCivil;
    
    @OneToMany (mappedBy = "condomino")
    private List<Produto> produtos;
    
    @ElementCollection (fetch = FetchType.EAGER)
    private List<String> telefones;
    
    @Transient
    private double reputacao;

    public Condomino() {
        telefones= new ArrayList<>();
        produtos= new ArrayList<>();
    }

    public Condomino(String nome) {
        this.nome = nome;
    }

    public Condomino(String nome, String cpf, String login, String senha, TipoUsuario tipoUsuario, Calendar dataNascimento, List<SolicitacaoAluguel> solicitacoes, Apartamento apartamento, EstadoCivil estadoCivil, List<Produto> produtos, List<String> telefones) {
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.dataNascimento = dataNascimento;
        this.solicitacoes = solicitacoes;
        this.apartamento = apartamento;
        this.estadoCivil = estadoCivil;
        this.produtos = produtos;
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

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<SolicitacaoAluguel> getSolicitacoes() {
        return solicitacoes;
    }

    public void setSolicitacoes(List<SolicitacaoAluguel> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }

    public double getReputacao() {
        AluguelDAO aluguelDAO = new AluguelDAO();
        this.reputacao = aluguelDAO.calculaReputacao(this);
        return reputacao;
    }

    @Override
    public String toString() {
        return nome;
    }
}