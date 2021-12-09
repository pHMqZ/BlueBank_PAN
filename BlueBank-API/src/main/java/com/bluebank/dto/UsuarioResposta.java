package com.bluebank.dto;

import com.bluebank.model.DadoUsuario;
import com.bluebank.model.Usuario;

public class UsuarioResposta {

	private Integer id;
	private String nome;
	private boolean admin;
	private DadoUsuario dado_usuario;
	private ContaResposta contaResposta;
	private Boolean status;
	private Integer num_conta;

	public static UsuarioResposta transformaDTO(Usuario usuario) {
		ContaResposta contaResp = ContaResposta.transformaConta(usuario.getConta());
		return new UsuarioResposta(usuario.getId(), usuario.getNome(), usuario.isAdmin(), usuario.getDado_usuario(),
				contaResp, usuario.getStatus());
	}

	public static UsuarioResposta transformaDTOAdmin(Usuario usuario) {
		return new UsuarioResposta(usuario.getId(), usuario.getNome(), usuario.isAdmin(), usuario.getStatus());
	}

	public static UsuarioResposta transformaDTOsemDados(Usuario usuario) {
		return new UsuarioResposta(usuario.getId(), usuario.getNome(), usuario.getConta().getId(), usuario.getStatus());
	}

	public UsuarioResposta(Integer id, String nome, boolean admin, DadoUsuario dado_usuario,
			ContaResposta contaResposta, Boolean status) {
		this.id = id;
		this.nome = nome;
		this.admin = admin;
		this.dado_usuario = dado_usuario;
		this.contaResposta = contaResposta;
		this.status = status;
	}

	public UsuarioResposta(Integer id, String nome, Boolean admin, Boolean status) {
		this.id = id;
		this.nome = nome;
		this.admin = admin;
		this.status = status;
	}

	public UsuarioResposta(Integer id, String nome, Integer num_conta, Boolean status) {
		this.id = id;
		this.nome = nome;
		this.num_conta = num_conta;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public ContaResposta getConta() {
		return contaResposta;
	}

	public void setConta(ContaResposta conta) {
		this.contaResposta = conta;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getNum_conta() {
		return num_conta;
	}

	public void setNum_conta(Integer num_conta) {
		this.num_conta = num_conta;
	}

}