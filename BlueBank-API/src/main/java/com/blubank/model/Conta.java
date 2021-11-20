package com.blubank.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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

    @ManyToOne
    private Agencia agencia;

    @ManyToMany(cascade=CascadeType.ALL, mappedBy = "conta")
    private List<Movimento> movimento;
    //@JoinColumn(name = "fk_movimento",nullable=false)

    @OneToOne(cascade=CascadeType.ALL)
    private Cliente cliente;
    //@JoinColumn(name = "fk_cliente",nullable=false)
    //private Cliente cliente;

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

    // public Cliente getCliente() {
    //     return this.cliente;
    // }

    // public void setCliente(Cliente cliente) {
    //     this.cliente = cliente;
    // }
    

}
