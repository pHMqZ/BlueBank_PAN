package com.bluebank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	

//	// o que cliente faz:
//
//	@Autowired
//	private UsuarioRepository usuarioRepo;
//
//	@Autowired
//	private DadoUsuarioRepository dadoClienteRepo;
//
//	// @Autowired
//	// private MovimentoRepository movimentoRepo;
//
//	// salvar os dados
//	@PostMapping // endpoint
//	public void salvaCliente(@RequestBody Usuario cliente, @RequestBody DadoUsuario dado) {
//
//		cliente.setNome(cliente.getNome());
//		dado.setCpf(dado.getCpf());
//		dado.setRua(dado.getRua());
//		dado.setNumero(dado.getNumero());
//		dado.setComplemento(dado.getComplemento());
//		dado.setBairro(dado.getBairro());
//		dado.setCidade(dado.getCidade());
//		dado.setEstado(dado.getEstado());
//		dado.setTelefone(dado.getTelefone());
//		dado.setEmail(dado.getEmail());
//
//		clienteRepo.save(cliente);
//		dadoClienteRepo.save(dado);
//	}
//
//	// editar dados cliente
//	@PutMapping
//	public void atualizaCliente(@PathVariable Integer id, @RequestBody Usuario cliente, @RequestBody DadoUsuario dado)
//			throws Exception {
//
//		var c = clienteRepo.findById(id);
//		var d = dadoClienteRepo.findById(id);
//
//		if (c.isPresent()) {
//			var clienteUpdate = cliente;
//			clienteUpdate.setNome(cliente.getNome());
//
//			clienteRepo.save(clienteUpdate);
//		} else {
//			throw new Exception("Cliente não cadastrado");
//		}
//
//		if (d.isPresent()) {
//			var dadoUpdate = dado;
//			dadoUpdate.setCpf(dado.getCpf());
//			dadoUpdate.setRua(dado.getRua());
//			dadoUpdate.setNumero(dado.getNumero());
//			dadoUpdate.setComplemento(dado.getComplemento());
//			dadoUpdate.setBairro(dado.getBairro());
//			dadoUpdate.setCidade(dado.getCidade());
//			dadoUpdate.setEstado(dado.getEstado());
//			dadoUpdate.setTelefone(dado.getTelefone());
//			dadoUpdate.setEmail(dado.getEmail());
//
//			dadoClienteRepo.save(dadoUpdate);
//		} else {
//			throw new Exception("Cliente não cadastrado");
//		}
//
//	}
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