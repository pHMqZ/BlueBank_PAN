package com.bluebank.dto;

import com.bluebank.model.DadoUsuario;
import com.bluebank.model.Usuario;

public class ClienteDto {
	
	private String nome;
	private String senha;
    private int cpf;
    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private int telefone;
    private String email;
	
    public static ClienteDto u(Usuario c, DadoUsuario d) {
    	var cliente = new ClienteDto();
    	cliente.setNome(c.getNome());
    	cliente.setSenha(c.getSenha());
    	cliente.setCpf(d.getCpf());
    	cliente.setRua(d.getRua());
    	cliente.setNumero(d.getNumero());
    	cliente.setComplemento(d.getComplemento());
    	cliente.setBairro(d.getBairro());
    	cliente.setCidade(d.getCidade());
    	cliente.setEstado(d.getEstado());
    	cliente.setTelefone(d.getTelefone());
		cliente.setEmail(d.getEmail());
		
    	
    	return cliente;	
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    
}
