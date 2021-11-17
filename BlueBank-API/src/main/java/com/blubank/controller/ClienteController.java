package com.blubank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blubank.model.Cliente;
import com.blubank.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	// o que cliente faz:

	@Autowired
	private ClienteRepository clienteRepo;

	// salvar os dados
	@PostMapping // endpoint
	public void salvaCliente(@RequestBody Cliente cliente) {

		cliente.setNome(cliente.getNome());

		// Verificar se é viável unificar table Cliente e Dados Clientes
		// para fazer os sets mais facilmente dos dados do cliente

		clienteRepo.save(cliente);
	}

	// editar dados cliente
	@PutMapping
	public void atualizaCliente(@PathVariable Long id, @RequestBody Cliente cliente) throws Exception {

		var c = clienteRepo.findById(id);

		if (c.isPresent()) {
			var clienteUpdate = cliente;
			clienteUpdate.setNome(cliente.getNome());

			clienteRepo.save(clienteUpdate);
		} else {
			throw new Exception("Cliente não cadastrado");
		}

	}

	// excluir dados
	@DeleteMapping
	public void deletaCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
		clienteRepo.deleteById(id);
	}

	// movimentação de conta(deposito/transferencia) -> GetMapping da movimentação
	// hist de movimentação

}