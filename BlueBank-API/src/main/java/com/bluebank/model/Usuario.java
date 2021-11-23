package com.bluebank.model;

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
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Long id; //conta bancaria;
	
	@Column(name ="nome_cliente")
	@NotEmpty(message ="O nome deve ser preenchido")
	private String nome;
	
	@Column(name ="senha_cliente")
	@NotEmpty(message = "A senha deve ser preenchida")
	private String senha;
	
	@OneToOne(cascade=CascadeType.ALL)
    private DadoUsuario dado_usuario;
	
	private boolean admin = false;
	
	public Long getId() {
		return this.id;
	}

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
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

	public DadoUsuario getDado_usuario() {
		return dado_usuario;
	}

	public void setDado_usuario(DadoUsuario dado_usuario) {
		this.dado_usuario = dado_usuario;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Usuario(String nome,String senha, DadoUsuario dado_usuario) {
		
		this.nome = nome;
		this.senha = senha;
		this.dado_usuario = dado_usuario;
	}
	
}