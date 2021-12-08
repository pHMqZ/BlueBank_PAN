package com.bluebank.controller;


import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebank.dto.ContaMovimentoResposta;
import com.bluebank.dto.ContaResposta;
import com.bluebank.dto.UsuarioDto;
import com.bluebank.dto.UsuarioResposta;

import com.bluebank.model.Usuario;

import com.bluebank.service.UsuarioService;


@RestController
@RequestMapping("/usuario/cliente")
public class UsuarioController {

	
	@Autowired
	UsuarioService usuarioService;

	@CrossOrigin(origins = "http://localhost:3006")
	@PostMapping("/salvar")
	public ResponseEntity<UsuarioResposta> salvar(@RequestBody UsuarioDto DTO){
		Usuario usuario = usuarioService.salvaCliente(DTO.transformaUsuario());
		return new ResponseEntity<> (UsuarioResposta.transformaDTO(usuario), HttpStatus.CREATED);
	}
	
	@GetMapping("/conta/{id}")
	public ContaResposta getContaById(@PathVariable Integer id){
		return usuarioService.findContaById(id);								
	}
	
	@PostMapping("/transferir/{id_origem}/{id_destino}/{valor}")
	public ResponseEntity<?> transferir
	(@PathVariable Integer id_origem,  @PathVariable Integer id_destino,  @PathVariable double valor) throws Exception{ //
		return usuarioService.transferir(id_origem, id_destino, valor);
	}
	
	
	@GetMapping("/historico/{id}")
	public List<ContaMovimentoResposta> getHistoricoMovimento(@PathVariable Integer id) throws Exception{
		return usuarioService.getHistoricoById(id);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> editarDados(@PathVariable Integer id, @RequestBody JSONObject jsonObject) throws Exception{
		return usuarioService.atualizarDadosPessoais(id, jsonObject);
	}
	
	


}
