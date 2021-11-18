package com.blubank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blubank.model.Cliente;
import com.blubank.model.DadoCliente;
import com.blubank.model.Movimento;
import com.blubank.repository.ClienteRepository;
import com.blubank.repository.DadoClienteRepository;
import com.blubank.repository.MovimentoRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	// o que cliente faz:

	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private DadoClienteRepository dadoClienteRepo;
	
	@Autowired
	private MovimentoRepository movimentoRepo;
	

	// salvar os dados
	@PostMapping // endpoint
	public void salvaCliente(@RequestBody Cliente cliente, @RequestBody DadoCliente dado) {

		cliente.setNome(cliente.getNome());
		dado.setCpf(dado.getCpf());
		dado.setRua(dado.getRua());
		dado.setNumero(dado.getNumero());
		dado.setComplemento(dado.getComplemento());
		dado.setBairro(dado.getBairro());
		dado.setCidade(dado.getCidade());
		dado.setEstado(dado.getEstado());
		dado.setTelefone(dado.getTelefone());
		dado.setEmail(dado.getEmail());
		

		clienteRepo.save(cliente);
		dadoClienteRepo.save(dado);
	}

	// editar dados cliente
	@PutMapping
	public void atualizaCliente(@PathVariable Integer id, @RequestBody Cliente cliente, @RequestBody DadoCliente dado) throws Exception {

		var c = clienteRepo.findById(id);
		var d = dadoClienteRepo.findById(id);

		if (c.isPresent()) {
			var clienteUpdate = cliente;
			clienteUpdate.setNome(cliente.getNome());

			clienteRepo.save(clienteUpdate);
		} else {
			throw new Exception("Cliente não cadastrado");
		}
		
		if(d.isPresent()) {
			var dadoUpdate = dado;
			dadoUpdate.setCpf(dado.getCpf());
			dadoUpdate.setRua(dado.getRua());
			dadoUpdate.setNumero(dado.getNumero());
			dadoUpdate.setComplemento(dado.getComplemento());
			dadoUpdate.setBairro(dado.getBairro());
			dadoUpdate.setCidade(dado.getCidade());
			dadoUpdate.setEstado(dado.getEstado());
			dadoUpdate.setTelefone(dado.getTelefone());
			dadoUpdate.setEmail(dado.getEmail());
			
			dadoClienteRepo.save(dadoUpdate);
		}else {
			throw new Exception("Cliente não cadastrado");
		}

	}

	// excluir dados
	@DeleteMapping
	public void deletaCliente(@PathVariable Integer id, @RequestBody Cliente cliente, @RequestBody DadoCliente dado) {
		clienteRepo.deleteById(id);
		dadoClienteRepo.deleteById(id);
	}

	// movimentação de conta(deposito/transferencia)
//	@PostMapping
//	public void transacoes(@PathVariable Integer id, @RequestBody Movimento movimento) {
//		
//	}
//	
//	
//	// hist de movimentação  -> GetMapping da movimentação
//	@GetMapping
//	public ResponseEntity<List<Movimento> getAll(){
//		//return ResponseEntity.ok(movimentoRepo.findAll());
//	}

}