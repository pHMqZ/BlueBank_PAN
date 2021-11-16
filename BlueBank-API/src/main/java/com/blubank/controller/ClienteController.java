package com.blubank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private DadoClienteRepository dadoClienteRepository;
	
	//o que cliente faz:
	
	@PostMapping //("/cadastro/clientes") 
	public ResponseEntity<Cliente> post(@RequestBody Cliente cliente){
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
	}
	
	@GetMapping
	public List<DadoCliente> findAll(){
		return  dadoClienteRepository.findAll();
		
	}
	
	@GetMapping(value = "/editar/clientes")
	public ResponseEntity<List<DadoCliente>> getById(){
		
	}
	//editar dados cliente
	//salvar os dados
	//excluir dados
	//movimentação de conta(deposito/transferencia)
	//hist de movimentação
	
}
