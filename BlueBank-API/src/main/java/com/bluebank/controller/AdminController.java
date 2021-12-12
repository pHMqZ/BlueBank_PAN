package com.bluebank.controller;

import com.bluebank.dto.ContaMovimentoResposta;
import com.bluebank.dto.UsuarioResposta;
import com.bluebank.model.DadoUsuario;
import com.bluebank.model.Usuario;

import com.bluebank.service.AdminService;
import com.bluebank.service.UsuarioService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("usuario/admin")
public class AdminController {
   
	@Autowired
	AdminService adminService;
	
	@Autowired
	UsuarioService usuarioService;

	@CrossOrigin(origins = "http://localhost:3006")
    @GetMapping("/listarUsuarios")
    public List<UsuarioResposta> userFindAll(){
    	return adminService.findAllUsers();
        
    }
    
	@CrossOrigin(origins = "http://localhost:3006")
    @GetMapping("/listarUsuarioId/{id}")
    public UsuarioResposta findById(@PathVariable("id") Integer id){
    	Usuario user =  usuarioService.getById(id);	
        return UsuarioResposta.transformaDTO(user);
    }

	@CrossOrigin(origins = "http://localhost:3006")
    @PostMapping("/bloquearUsuario/{id}")
    public void bloqueiaUser(@PathVariable("id") Integer id){
    	adminService.bloqueiaUser(id);
    }

	@CrossOrigin(origins = "http://localhost:3006")
    @PostMapping("/desbloquearUsuario/{id}")
    public void desbloqueiaUser(@PathVariable("id") Integer id){
    	adminService.desbloqueiaUser(id);
       
    }

	@CrossOrigin(origins = "http://localhost:3006")
    @PutMapping("/editarUser/{id}")
    public ResponseEntity<?> editarDados(@PathVariable Integer id, @RequestBody JSONObject jsonObject) throws Exception{
    	try {
			Usuario cliente = usuarioService.getById(id);
			DadoUsuario dadosUsuario = usuarioService.findDadosById(id);
			usuarioService.atualizaDadosCliente(cliente, dadosUsuario,jsonObject);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch(Exception e) {
			throw new Exception(e);
		}
    }
    
	@CrossOrigin(origins = "http://localhost:3006")
    @GetMapping("/historico/{id}")
	public List<ContaMovimentoResposta> getHistoricoMovimento(@PathVariable Integer id) throws Exception{
    	return usuarioService.getHistoricoById(id);
	}
    
	@CrossOrigin(origins = "http://localhost:3006")
    @GetMapping("/historicoGeral")
    public List<ContaMovimentoResposta> getHistoricoMovimentoGeral() throws Exception{
		return adminService.getHistoricoGeral();
	}
    


}