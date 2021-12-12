package com.bluebank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.bluebank.dto.ContaMovimentoResposta;
import com.bluebank.dto.UsuarioResposta;

import com.bluebank.model.Movimento;
import com.bluebank.model.Usuario;

import com.bluebank.repository.MovimentoRepository;
import com.bluebank.repository.UsuarioRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Autowired
	private MovimentoRepository movimentoRepository;

	@Override
	public Usuario cadastrarAdmin(Usuario usuario) {
		usuario.setAdmin(true);
		return usuarioRepo.save(usuario);
	}

	@Override
	public List<Usuario> userFindAll() {
		return usuarioRepo.findAll();
	}

	@Override
	public Usuario userFindById(Integer id) {
		return usuarioRepo.findById(id).get();
	}

	@Override
	public void bloqueiaUser(Integer id) {
		Usuario usuario = usuarioRepo.getById(id);
		usuario.setStatus(false);
		usuarioRepo.save(usuario);
	}

	@Override
	public void desbloqueiaUser(Integer id) {
		Usuario usuario = usuarioRepo.getById(id);
		usuario.setStatus(true);
		usuarioRepo.save(usuario);

	}

	@Override
	public Movimento movimentoFindById(Integer id) {
		return movimentoRepository.findById(id).get();
	}

	@Override
	public List<Movimento> movimentoFindAll() {
		return movimentoRepository.findAll();
	}

	@Override
	public List<UsuarioResposta> findAllUsers() {
		List<UsuarioResposta> resposta = new ArrayList<UsuarioResposta>();
		List<Usuario> usuarios = usuarioRepo.findAll();
		for (Usuario usuario : usuarios) {
			resposta.add(UsuarioResposta.transformaDTOsemDados(usuario));
		}
		return resposta;
	}

	@Override
	public List<ContaMovimentoResposta> getHistoricoGeral() throws Exception {
		try {
			List<Movimento> movimentos = movimentoFindAll();
			List<ContaMovimentoResposta> movimentosResposta = new ArrayList<ContaMovimentoResposta>();
			for (Movimento movimento : movimentos) {
				movimentosResposta.add(ContaMovimentoResposta.transformaMovimento(movimento));
			}
			return movimentosResposta;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}
