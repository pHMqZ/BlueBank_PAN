package com.bluebank.controller;

import com.bluebank.dto.UsuarioDto;
import com.bluebank.dto.UsuarioResposta;
import com.bluebank.model.Conta;
import com.bluebank.model.Usuario;
import com.bluebank.repository.ContaRepository;
import com.bluebank.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario/cliente")
public class UsuarioController {

	//	o que cliente faz:
	
	private final UsuarioService usuarioService;

	@Autowired
	private ContaRepository contaRepository;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<UsuarioResposta> salvar(@RequestBody UsuarioDto DTO){
		Usuario usuario = usuarioService.salvaCliente(DTO.transformaUsuario());
		return new ResponseEntity<> (UsuarioResposta.transformaDTO(usuario), HttpStatus.CREATED);
	}

	@GetMapping("/conta/{id}")
	public ResponseEntity<Conta> getContaById(@PathVariable Integer id){
		return contaRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());    									
	}
	
	


}
//	// o que cliente faz:
  
//
//	// excluir dados
//	@DeleteMapping
//	public void deletaCliente(@PathVariable Integer id, @RequestBody Usuario cliente, @RequestBody DadoUsuario dado) {
//		clienteRepo.deleteById(id);
//		dadoClienteRepo.deleteById(id);
//	}

//  movimentação de conta(deposito/transferencia)
//	@PostMapping
//	public void transacoes(@PathVariable Integer id, @RequestBody Movimento movimento) {
//		
//	}
//	
//	
//	hist de movimentação  -> GetMapping da movimentação
//	@GetMapping
//	public ResponseEntity<List<Movimento> getAll(){
//		//return ResponseEntity.ok(movimentoRepo.findAll());
//	}
