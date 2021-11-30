package com.bluebank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebank.dto.ContaMovimentoResposta;
import com.bluebank.dto.UsuarioDto;
import com.bluebank.dto.UsuarioResposta;
import com.bluebank.model.Conta;
import com.bluebank.model.DadoUsuario;
import com.bluebank.model.Movimento;
import com.bluebank.model.Usuario;
import com.bluebank.repository.ContaRepository;
import com.bluebank.repository.DadoUsuarioRepository;
import com.bluebank.repository.MovimentoRepository;
import com.bluebank.repository.UsuarioRepository;
import com.bluebank.service.UsuarioService;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@RestController
@RequestMapping("/usuario/cliente")
public class UsuarioController {

	//	o que cliente faz:
	
	private final UsuarioService usuarioService;

	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private DadoUsuarioRepository dadoUsuarioRepository;
	
	
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
	
	@PostMapping("/transferir/{id_origem}/{id_destino}/{valor}")
	public ResponseEntity<?> transferir
	(@PathVariable Integer id_origem,  @PathVariable Integer id_destino,  @PathVariable double valor) throws Exception{ //
		try {
			Conta contaOrigem = contaRepository.findById(id_origem).orElseThrow();
			Conta contaDestino = contaRepository.findById(id_destino).orElseThrow();
			usuarioService.transferirDinheiro(contaOrigem, contaDestino,valor);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch (Exception e){
			throw new Exception(e);
		}
		
	}
	
	
	@GetMapping("/historico/{id}")
	public List<ContaMovimentoResposta> getHistoricoMovimento(@PathVariable Integer id) throws Exception{
		try {
			List<Movimento> movimentos = contaRepository.findByContaId(id);
			List<ContaMovimentoResposta> movimentosResposta = new ArrayList<ContaMovimentoResposta>();
			for(Movimento movimento: movimentos){
				movimentosResposta.add(ContaMovimentoResposta.transformaMovimento(movimento));
				
				}
			return  movimentosResposta;
		}catch (Exception e){
			throw new Exception(e);
		}
		
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> editarDados(@PathVariable Integer id, @RequestBody JSONObject jsonObject) throws Exception{
		try {
			Usuario cliente = usuarioRepository.findById(id).orElseThrow();
			DadoUsuario dadosUsuario = dadoUsuarioRepository.findById(id).orElseThrow();
			usuarioService.atualizaDadosCliente(cliente, dadosUsuario,jsonObject );
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch(Exception e) {
			throw new Exception(e);
		}
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
