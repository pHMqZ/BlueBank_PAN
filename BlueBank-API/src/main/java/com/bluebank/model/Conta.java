package com.bluebank.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
    @JoinColumn(name = "fk_cliente",nullable=false)
    private Usuario cliente;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_movimento",nullable=false)
    private Movimento movimento;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_abertura() {
        return this.data_abertura;
    }

    public void setData_abertura(Date data_abertura) {
        this.data_abertura = data_abertura;
    }

    public Date getData_fechamento() {
        return this.data_fechamento;
    }

    public void setData_fechamento(Date data_fechamento) {
        this.data_fechamento = data_fechamento;
    }

    public boolean isDebito() {
        return this.debito;
    }

    public boolean getDebito() {
        return this.debito;
    }

    public void setDebito(boolean debito) {
        this.debito = debito;
    }

    public Usuario getCliente() {
        return this.cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }
    

}
