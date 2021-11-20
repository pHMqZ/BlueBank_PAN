package com.bluebank.dto;

import com.bluebank.model.DadoUsuario;
import com.bluebank.model.Usuario;

public class UsuarioResposta {
	
	private Long id;
	private String nome;
	private boolean admin;
	private DadoUsuario dado_usuario;
	
	public static UsuarioResposta transformaDTO(Usuario usuario) {
		return new UsuarioResposta(usuario.getId(), usuario.getNome(), usuario.isAdmin(), usuario.getDado_usuario());
	}

	public UsuarioResposta(Long id, String nome, boolean admin, DadoUsuario dado_usuario) {
		this.id = id;
		this.nome = nome;
		this.admin = admin;
		this.dado_usuario = dado_usuario;
	}

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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public DadoUsuario getDado_usuario() {
		return dado_usuario;
	}

	public void setDado_usuario(DadoUsuario dado_usuario) {
		this.dado_usuario = dado_usuario;
	}
    
	
}
	