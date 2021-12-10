package com.bluebank.dto;

import java.util.Date;

import com.bluebank.model.Agencia;
import com.bluebank.model.Conta;

public class ContaResposta {
	private Integer id;
	private double saldo;
	private String nome;
	private Date data_abertura;
	private Date data_fechamento;
	private boolean debito;
	private Agencia age;

	public ContaResposta(Integer id, double saldo, String nome, Date data_abertura, Date data_fechamento,
			boolean debito, Agencia age) {

		this.id = id;
		this.saldo = saldo;
		this.nome = nome;
		this.data_abertura = data_abertura;
		this.data_fechamento = data_fechamento;
	}

	public static ContaResposta transformaConta(Conta conta) {
		return new ContaResposta(conta.getId(), conta.getSaldo(), conta.getNome(), conta.getData_abertura(),
				conta.getData_fechamento(), conta.getDebito(), conta.getAge());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
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

	public Agencia getAge() {
		return age;
	}

	public void setAge(Agencia age) {
		this.age = age;
	}

}
