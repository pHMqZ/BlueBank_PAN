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
import java.util.List;

@Entity
@Table(name="agencia")
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agencia")
    private int id;

    @Column(name = "nome_agencia")
    private String nome_agencia;

    @Column(name = "status")
    private Boolean status = true;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_conta",nullable=false)
    private List<Conta> conta;

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

    public List<Conta> getConta() {
        return this.conta;
    }

    public void setConta(List<Conta> conta) {
        this.conta = conta;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
