package com.bluebank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebank.dto.UsuarioDto;
import com.bluebank.dto.UsuarioResposta;
import com.bluebank.model.Usuario;
import com.bluebank.service.UsuarioService;

@RestController
@RequestMapping("/usuario/cliente")
public class UsuarioController {

	//	o que cliente faz:
	
	private final UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@PostMapping("*/salvar")
	public ResponseEntity<UsuarioResposta> salvar(@RequestBody UsuarioDto DTO){
		Usuario usuario = usuarioService.salvaCliente(DTO.transformaUsuario());
		return new ResponseEntity<> (UsuarioResposta.transformaDTO(usuario), HttpStatus.CREATED);
	}
	
	
}