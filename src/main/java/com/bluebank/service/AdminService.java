package com.bluebank.service;

import com.bluebank.dto.ContaMovimentoResposta;
import com.bluebank.dto.UsuarioResposta;

import com.bluebank.model.Movimento;
import com.bluebank.model.Usuario;




import java.util.List;


public interface AdminService {

	public abstract Usuario cadastrarAdmin(Usuario usuario);
    public abstract  List<Usuario> userFindAll();
	public abstract Usuario userFindById(Integer id);
	public abstract void bloqueiaUser(Integer id);
    public abstract void desbloqueiaUser(Integer id);
    public abstract Movimento movimentoFindById(Integer id);
    public abstract List<Movimento> movimentoFindAll();
    public abstract List<UsuarioResposta> findAllUsers();
    public abstract List<ContaMovimentoResposta> getHistoricoGeral() throws Exception;


   
}
