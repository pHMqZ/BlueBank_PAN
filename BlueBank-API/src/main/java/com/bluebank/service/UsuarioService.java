package com.bluebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.bluebank.model.Usuario;
import com.bluebank.model.DadoUsuario;
import com.bluebank.repository.UsuarioRepository;
import com.bluebank.repository.DadoUsuarioRepository;
import com.bluebank.repository.MovimentoRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Autowired
	private DadoUsuarioRepository dadoUsuarioRepo;
	
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
