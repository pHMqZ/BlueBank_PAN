package com.blubank.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private Date data;

    @Column(name = "data_fechamento")
    private Date data;

    @Column(name = "debito_bloqueado")
    private boolean debito;

    @Column(name = "cliente_id_cliente")
    private int cliente_id;


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

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public int getCliente_id() {
        return this.cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

}
