package com.bluebank.service;

import java.util.List;

import org.json.simple.JSONObject;

import org.springframework.http.ResponseEntity;


import com.bluebank.model.Usuario;
import com.bluebank.dto.ContaMovimentoResposta;
import com.bluebank.dto.ContaResposta;
import com.bluebank.model.Conta;
import com.bluebank.model.DadoUsuario;



public interface UsuarioService {


	public abstract Usuario salvaCliente(Usuario usuario);
	public abstract void transferirDinheiro(Conta contaOrigem, Conta contaDestino, double valor ) throws Exception;
	public abstract void atualizaDadosCliente( Usuario usuario, DadoUsuario dado, JSONObject jsonObject) throws Exception;
	public abstract ContaResposta findContaById(Integer id);
	public abstract Usuario getById(Integer id);
	public abstract DadoUsuario findDadosById(Integer id);
	public abstract List<ContaMovimentoResposta> getHistoricoById(Integer id)throws Exception;
	public abstract ResponseEntity<?> transferir(Integer id_origem, Integer id_destino, double valor) throws Exception;
	public abstract ResponseEntity<?> atualizarDadosPessoais(Integer id, JSONObject jsonObject) throws Exception;
	

	
}
