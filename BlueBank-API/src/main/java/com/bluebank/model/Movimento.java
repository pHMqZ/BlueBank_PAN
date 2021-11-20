package com.bluebank.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="movimento")
public class Movimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transacao")
    private int id;

    @Column(name = "data_movimento")
    private Date data_movimento;

    @Column(name = "tipo_movimento")
    private String tipo_movimento;

    @Column(name = "valor")
    private int valor;

    @Column(name = "numero_doc")
    private int numero_doc;

    @Column(name = "saldo")
    private int saldo;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_conta",nullable=false)
    private Conta conta;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_movimento() {
        return this.data_movimento;
    }

    public void setData_movimento(Date data_movimento) {
        this.data_movimento = data_movimento;
    }

    public String getTipo_movimento() {
        return this.tipo_movimento;
    }

    public void setTipo_movimento(String tipo_movimento) {
        this.tipo_movimento = tipo_movimento;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getNumero_doc() {
        return this.numero_doc;
    }

    public void setNumero_doc(int numero_doc) {
        this.numero_doc = numero_doc;
    }

    public int getSaldo() {
        return this.saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Conta getConta() {
        return this.conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

}
