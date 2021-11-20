package com.bluebank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	

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

}