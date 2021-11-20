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

	// @Autowired
	// private MovimentoRepository movimentoRepo;

	public void salvaCliente(Usuario usuario, DadoUsuario dado) {

		usuario.setNome(usuario.getNome());
		usuario.setSenha(usuario.getSenha());
		dado.setCpf(dado.getCpf());
		dado.setRua(dado.getRua());
		dado.setNumero(dado.getNumero());
		dado.setComplemento(dado.getComplemento());
		dado.setBairro(dado.getBairro());
		dado.setCidade(dado.getCidade());
		dado.setEstado(dado.getEstado());
		dado.setTelefone(dado.getTelefone());
		dado.setEmail(dado.getEmail());

		usuarioRepo.save(usuario);
		dadoUsuarioRepo.save(dado);

	}

	public void atualizaCliente(@PathVariable Integer id, Usuario usuario, DadoUsuario dado) throws Exception {
		
		var u = usuarioRepo.findById(id);
		var d = dadoUsuarioRepo.findById(id);
		
		if(u.isPresent()) {
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

}
