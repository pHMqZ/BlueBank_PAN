package com.bluebank.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="agencia")
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agencia")
    private int id;

    @Column(name = "nome_agencia")
    private String nome_agencia;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_conta",nullable=false)
    private Conta conta;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_agencia() {
        return this.nome_agencia;
    }

    public void setNome_agencia(String nome_agencia) {
        this.nome_agencia = nome_agencia;
    }

    public Conta getConta() {
        return this.conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }


}
