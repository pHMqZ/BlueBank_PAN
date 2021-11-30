package com.bluebank.service;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.bluebank.model.Usuario;
import com.bluebank.model.Conta;
import com.bluebank.model.DadoUsuario;
import com.bluebank.model.Movimento;
import com.bluebank.repository.UsuarioRepository;
import com.bluebank.repository.ContaRepository;
import com.bluebank.repository.DadoUsuarioRepository;
import com.bluebank.repository.MovimentoRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Autowired
	private DadoUsuarioRepository dadoUsuarioRepo;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private MovimentoRepository movimentoRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepo) {
		this.usuarioRepo = usuarioRepo;
	}

	// @Autowired
	// private MovimentoRepository movimentoRepo;

	public Usuario salvaCliente(Usuario usuario) {
		return usuarioRepo.save(usuario);
	}
	
//	public void salvarClienteDados(DadoUsuario dado) {
//
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
//		dadoUsuarioRepo.save(dado);
//	}

	
	
	
	
	
	public void atualizaCliente(@PathVariable Integer id, Usuario usuario, DadoUsuario dado) throws Exception {

		var u = usuarioRepo.findById(id);
		var d = dadoUsuarioRepo.findById(id);

		if (u.isPresent()) {
			var usuarioUpdate = usuario;

			usuario.setNome(usuario.getNome());
			usuario.setSenha(usuario.getSenha());

			usuarioRepo.save(usuarioUpdate);
		} else {
			throw new Exception("Usuario não cadastrado");
		}

		if (d.isPresent()) {

			var dadoUpdate = dado;

			dado.setCpf(dado.getCpf());
			dado.setRua(dado.getRua());
			dado.setNumero(dado.getNumero());
			dado.setComplemento(dado.getComplemento());
			dado.setBairro(dado.getBairro());
			dado.setCidade(dado.getCidade());
			dado.setEstado(dado.getEstado());
			dado.setTelefone(dado.getTelefone());
			dado.setEmail(dado.getEmail());

			dadoUsuarioRepo.save(dadoUpdate);
		} else {
			throw new Exception("Cliente não cadastrado");
		}
	}

	public void deletaCliente(@PathVariable Integer id, Usuario usuario, DadoUsuario dado) {
		usuarioRepo.deleteById(id);
		dadoUsuarioRepo.deleteById(id);
	}
	
	
	public void transferirDinheiro(Conta contaOrigem, Conta contaDestino, double valor ) throws Exception {
		
		
		if(contaOrigem.getSaldo() >= valor) {
			double saldoAtual = contaOrigem.getSaldo();
			contaOrigem.setSaldo(saldoAtual-valor);
			
			
			double saldoAtual2 = contaDestino.getSaldo();
			contaDestino.setSaldo(saldoAtual2 + valor);
			
			//setar movimento
			String nome_conta_origem = contaOrigem.getNome();
			String nome_conta_destino= contaDestino.getNome();
			
			Movimento movimentoOrigem = new Movimento(valor, "Transferência", contaOrigem, nome_conta_destino);
			Movimento movimentoDestino = new Movimento(valor, "Recebimento", contaDestino, nome_conta_origem);
			
			List<Movimento> mov_origem = contaOrigem.getMovimento();
			mov_origem.add(movimentoOrigem);
			contaOrigem.setMovimento(mov_origem);
			
			List<Movimento> mov_destino = contaDestino.getMovimento();
			mov_destino.add(movimentoDestino);
			contaDestino.setMovimento(mov_destino);
			
			
			movimentoRepository.save(movimentoOrigem);
			movimentoRepository.save(movimentoDestino);
			contaRepository.save(contaOrigem);
			contaRepository.save(contaDestino);
			
			
			
			
		}else {
			throw new Exception("Não se pode fazer essa transferência");
		}
	}
	
	public void atualizaDadosCliente( Usuario usuario, DadoUsuario dado, JSONObject jsonObject) throws Exception {
		
		
		int telefone;
		String email;
		String bairro;
		String complemento;
		String rua;
		String estado;
		String cidade; 
		
		try {
			telefone = (int) jsonObject.get("telefone");
			email = (String) jsonObject.get("email");
			bairro = (String) jsonObject.get("bairro");
			complemento = (String) jsonObject.get("complemento");
			rua = (String) jsonObject.get("rua");
			estado = (String) jsonObject.get("estado");
			cidade = (String) jsonObject.get("cidade");
			
			dado.setTelefone(telefone);
			dado.setEmail(email);
			dado.setBairro(bairro);
			dado.setComplemento(complemento);
			dado.setRua(rua);
			dado.setEstado(estado);
			dado.setCidade(cidade);
			
			dadoUsuarioRepo.save(dado);
			
			
			
			
		}catch(Exception e) {
			throw new Exception(e);
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	

//  movimentação de conta(deposito/transferencia)
//
//	public void transacoes(@PathVariable Integer id, @RequestBody Movimento movimento) {
//		
//	}
//	
//	
//	hist de movimentação  -> GetMapping da movimentação
//	
//	public ResponseEntity<List<Movimento> getAll(){
//		//return ResponseEntity.ok(movimentoRepo.findAll());
//	}

}
