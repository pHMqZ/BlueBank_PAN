package com.blubank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="clientes")
public class Clientes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Long id; //conta bancaria;
	
	@NotEmpty(message ="O nome deve ser preenchido")
	private String nome;
	
	@NotEmpty(message ="O sobrenome deve ser preenchido")
	private String sobrenome;
	
	@NotEmpty(message ="O CPF deve ser preenchido")
	private Long cpf;
	
	@NotEmpty(message ="O telefone deve ser preenchido")
	private Long tel;
	
	@NotEmpty(message ="O email deve ser preenchido")
	private String email;
	
	@NotEmpty(message ="A senha deve ser preenchida")
	private String senha;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Long getTel() {
		return tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
