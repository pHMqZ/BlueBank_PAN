package com.bluebank.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private int id;
    
    @Column(name = "nome_conta")
    private String nome;

    @Column(name = "data_abertura")
    private Date data_abertura;

    @Column(name = "data_fechamento")
    private Date data_fechamento;

    @Column(name = "debito_bloqueado")
    private boolean debito;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_usuario",nullable=false)
    private Usuario usuario;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_movimento",nullable=false)
    private List<Movimento> movimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(Date data_abertura) {
        this.data_abertura = data_abertura;
    }

    public Date getData_fechamento() {
        return data_fechamento;
    }

    public void setData_fechamento(Date data_fechamento) {
        this.data_fechamento = data_fechamento;
    }

    public boolean isDebito() {
        return debito;
    }

    public void setDebito(boolean debito) {
        this.debito = debito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Movimento> getMovimento() {
        return movimento;
    }

    public void setMovimento(List<Movimento> movimento) {
        this.movimento = movimento;
    }
}
