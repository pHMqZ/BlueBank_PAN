package com.bluebank.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    private double valor;

    @Column(name = "numero_doc")
    private int numero_doc;
    
    @Column(name ="nome_terceiro")
    private String nome_conta;
    
    


    @ManyToOne
    private Conta conta;

 
    
    public Movimento(double valor, String tipo_movimento, Conta contaOrigem, String nome_conta) {
    	this.valor = valor;
    	this.tipo_movimento = tipo_movimento;
    	this.conta = contaOrigem;
    	this.nome_conta = nome_conta;
    }
    
    public Movimento() {
    	
    }

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

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getNumero_doc() {
        return this.numero_doc;
    }

    public void setNumero_doc(int numero_doc) {
        this.numero_doc = numero_doc;
    }
	public String getNome_conta() {
		return nome_conta;
	}
	public void setNome_conta(String nome_conta) {
		this.nome_conta = nome_conta;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}

	

    

}
