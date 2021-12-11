package com.bluebank.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.bluebank.dto.ContaMovimentoResposta;
import com.bluebank.dto.ContaResposta;
import com.bluebank.model.Conta;
import com.bluebank.model.DadoUsuario;
import com.bluebank.model.Movimento;
import com.bluebank.model.Usuario;
import com.bluebank.repository.ContaRepository;
import com.bluebank.repository.DadoUsuarioRepository;
import com.bluebank.repository.MovimentoRepository;
import com.bluebank.repository.UsuarioRepository;


@Service
public class UsuarioServiceImpl  implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Autowired
	private DadoUsuarioRepository dadoUsuarioRepo;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private MovimentoRepository movimentoRepository;
	
	
	@Override
	public Usuario salvaCliente(Usuario usuario) {
		return usuarioRepo.save(usuario);
	}
	

	@Override
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
	
	
	@Override
	public void atualizaDadosCliente( Usuario usuario, DadoUsuario dado, JSONObject jsonObject) throws Exception {
		String telefone;
		String email;
		String bairro;
		String complemento;
		String rua;
		String estado;
		String cidade; 
		String cpf;
		
		try {
			telefone = (String) jsonObject.get("telefone");
			email = (String) jsonObject.get("email");
			bairro = (String) jsonObject.get("bairro");
			complemento = (String) jsonObject.get("complemento");
			rua = (String) jsonObject.get("rua");
			estado = (String) jsonObject.get("estado");
			cidade = (String) jsonObject.get("cidade");
			cpf = (String) jsonObject.get("cpf");
			
			dado.setTelefone(telefone);
			dado.setEmail(email);
			dado.setBairro(bairro);
			dado.setComplemento(complemento);
			dado.setRua(rua);
			dado.setEstado(estado);
			dado.setCidade(cidade);
			dado.setCpf(cpf);
			
			dadoUsuarioRepo.save(dado);
		}catch(Exception e) {
			throw new Exception(e);
		}
	}
	
	@Override
	public ContaResposta  findContaById(Integer id){
		ContaResposta contaResposta =  ContaResposta.transformaConta(contaRepository.findById(id).orElseThrow());
		return  contaResposta ; 	
	}
	
	@Override
	public Usuario getById(Integer id) {
		return usuarioRepo.getById(id);
	}
	
	@Override 
	public DadoUsuario findDadosById(Integer id) {
		return dadoUsuarioRepo.getById(id);
	}
	
	@Override
	public List<ContaMovimentoResposta> getHistoricoById(Integer id) throws Exception{
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
	
	
	@Override
	public ResponseEntity<?> transferir( Integer id_origem,   Integer id_destino,   double valor)throws Exception{
		try {
			Conta contaOrigem = contaRepository.findById(id_origem).orElseThrow();
			Conta contaDestino = contaRepository.findById(id_destino).orElseThrow();
			transferirDinheiro(contaOrigem, contaDestino,valor);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch (Exception e){
			throw new Exception(e);
		}
		
	}
	
	@Override
	public ResponseEntity<?> atualizarDadosPessoais( Integer id,  JSONObject jsonObject)throws Exception{
		try {
			Usuario cliente = usuarioRepo.findById(id).orElseThrow();
			DadoUsuario dadosUsuario = dadoUsuarioRepo.findById(id).orElseThrow();
			atualizaDadosCliente(cliente, dadosUsuario,jsonObject );
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch(Exception e) {
			throw new Exception(e);
		}
	}
	
	@Override
	public String pegarSenhaUser(Integer id) throws Exception{
		try {
			Usuario cliente = usuarioRepo.findById(id).orElseThrow();
			return cliente.getSenha();
		}catch(Exception e) {
			throw new Exception(e);
		}
	}
	
	@Override
	public Integer pegarIds() throws Exception{
		try {
			Integer idResp = 1;
			List<Integer> resposta = new ArrayList<>();
			for(Usuario pessoa : usuarioRepo.findAll()) {
				resposta.add(pessoa.getId());
			}
			
			if(!resposta.isEmpty()) {
				idResp = resposta.size();
			}
			
			return idResp;
			
			
			
		}catch(Exception e) {
			
			throw new Exception(e);
		}
	}
	
	

	
}
