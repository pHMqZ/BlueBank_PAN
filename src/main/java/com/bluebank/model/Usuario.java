package com.bluebank.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome")
	@NotEmpty(message = "O nome deve ser preenchido")
	private String nome;

	@Column(name = "senha")
	@NotEmpty(message = "A senha deve ser preenchida")
	private String senha;

	@OneToOne(cascade = CascadeType.ALL)
	private Conta conta;

	@OneToOne(cascade = CascadeType.ALL)
	private DadoUsuario dado_usuario;

	@Column(name = "data_nascimento")
	private Date data_nasc;

	@Column(name = "status")
	private Boolean status = true;

	@Column(name = "admin")
	private boolean admin = false;

	public Usuario(String nome, String senha, DadoUsuario dado_usuario, Conta conta) {
		this.nome = nome;
		this.senha = senha;
		this.dado_usuario = dado_usuario;
		this.conta = conta;
	}

	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	public Usuario() {

	}

	// Metodos
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

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public DadoUsuario getDado_usuario() {
		return dado_usuario;
	}

	public void setDado_usuario(DadoUsuario dado_usuario) {
		this.dado_usuario = dado_usuario;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}