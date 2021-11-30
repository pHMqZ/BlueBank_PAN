package com.bluebank.dto;

import java.sql.Date;

import com.bluebank.model.Movimento;
import com.bluebank.model.Usuario;


public class ContaMovimentoResposta {
	private int id;
    private Date data_movimento;
    private String tipo_movimento;
    private double valor;
    private String nome_conta;
    
    public ContaMovimentoResposta(int id2, Date data_movimento2, String tipo_movimento2, double valor2,
			String nome_conta2) {
		
    	this.id = id2;
    	this.data_movimento = data_movimento2;
    	this.tipo_movimento = tipo_movimento2;
    	this.valor = valor2;
    	this.nome_conta = nome_conta2;
	}

	public ContaMovimentoResposta() {
		
	}

	public static ContaMovimentoResposta transformaMovimento(Movimento movimento) {
		return new ContaMovimentoResposta(movimento.getId(), movimento.getData_movimento(), movimento.getTipo_movimento(),movimento.getValor(), movimento.getNome_conta());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData_movimento() {
		return data_movimento;
	}

	public void setData_movimento(Date data_movimento) {
		this.data_movimento = data_movimento;
	}

	public String getTipo_movimento() {
		return tipo_movimento;
	}

	public void setTipo_movimento(String tipo_movimento) {
		this.tipo_movimento = tipo_movimento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getNome_conta() {
		return nome_conta;
	}

	public void setNome_conta(String nome_conta) {
		this.nome_conta = nome_conta;
	}
    
	
	
    
}
