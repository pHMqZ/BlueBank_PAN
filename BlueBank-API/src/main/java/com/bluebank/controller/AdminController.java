package com.bluebank.controller;

import com.bluebank.dto.ContaMovimentoResposta;
import com.bluebank.dto.UsuarioDto;
import com.bluebank.dto.UsuarioResposta;
import com.bluebank.model.DadoUsuario;
import com.bluebank.model.Movimento;
import com.bluebank.model.Usuario;
import com.bluebank.repository.AgenciaRepository;
import com.bluebank.repository.ContaRepository;
import com.bluebank.repository.DadoUsuarioRepository;
import com.bluebank.repository.MovimentoRepository;
import com.bluebank.repository.UsuarioRepository;
import com.bluebank.service.AdminService;

import lombok.NoArgsConstructor;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("usuario/admin")
public class AdminController {
    //Funções do Admin
//    Escopo = Usuário
    //    - Cadastrar Admin
       
//    Escopo = Agência
    //    - Criar agência(s)
    //    - Listar agência(s) (EXTRA)
    //    - Editar agência(s)
    //    - Desativar agência(s) (EXTRA)
    //    - Ativar agência(s) (EXTRA)
//    Escopo = Movimento
    //    - Listar Movimento(s)
//##############################################################################
    private final AdminService adminService;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private DadoUsuarioRepository dadoUsuarioRepository;
    
    
    @Autowired
	private ContaRepository contaRepository;


    
   
    public AdminController(AdminService adminService) {
		this.adminService = adminService;
    	
    }
    
    
    public AdminController() {
		this.adminService = new AdminService();
    	
    }
    
   
    
    
   

    @PostMapping("/salvar")
    public ResponseEntity<UsuarioResposta> cadastrarAdmin(@RequestBody UsuarioDto usuarioDto){
        Usuario usuario = adminService.cadastrarAdmin(usuarioDto.transformaAdmin());
        return new ResponseEntity<>(UsuarioResposta.transformaDTOAdmin(usuario), HttpStatus.CREATED);
    }

    @GetMapping("/listarUsuarios")
    public List<UsuarioResposta> userFindAll(){
    	List<Usuario> usuarios = usuarioRepository.findAll();
    	List<UsuarioResposta> resposta = new ArrayList<UsuarioResposta>();
    	for(Usuario usuario: usuarios){
    		resposta.add(UsuarioResposta.transformaDTOsemDados(usuario));
			}
 
    	return resposta;
        
    }
    
    @GetMapping("/listarUsuariosSemDados")
    public List<UsuarioResposta> userFindAllNoData(){
        var user = adminService.userFindAll();
        return user.stream().map(UsuarioResposta::transformaDTOsemDados).collect(Collectors.toList());
    }
    
    @GetMapping("/listarUsuarioId/{id}")
    public UsuarioResposta findById(@PathVariable("id") Integer id){
        var user = adminService.userFindById(id);
        return UsuarioResposta.transformaDTO(user);
    }

    @PostMapping("/bloquearUsuario")
    public UsuarioResposta bloqueiaUser(@PathVariable("id") Integer id){
        Usuario user = adminService.bloqueiaUser(id);
       return UsuarioResposta.transformaDTO(user);
    }

    @PostMapping("/desbloquearUsuario")
    public UsuarioResposta desbloqueiaUser(@PathVariable("id") Integer id){
        Usuario user = adminService.desbloqueiaUser(id);
        return UsuarioResposta.transformaDTO(user);
    }

    @PutMapping("/editarUser/{id}")
    public ResponseEntity<?> editarDados(@PathVariable Integer id, @RequestBody JSONObject jsonObject) throws Exception{
        try {
            Usuario user = usuarioRepository.findById(id).orElseThrow();
            DadoUsuario dadosUsuario = dadoUsuarioRepository.findById(id).orElseThrow();
            adminService.updateUser(user, dadosUsuario,jsonObject );
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e) {
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
    
    
    @GetMapping("/historicoGeral")
    public List<ContaMovimentoResposta> getHistoricoMovimentoGeral() throws Exception{
		try {
			List<Movimento> movimentos = adminService.movimentoFindAll();
			List<ContaMovimentoResposta> movimentosResposta = new ArrayList<ContaMovimentoResposta>();
			for(Movimento movimento: movimentos){
				movimentosResposta.add(ContaMovimentoResposta.transformaMovimento(movimento));
				}
			return  movimentosResposta;
		}catch (Exception e){
			throw new Exception(e);
		}
		
	}
    
    





//    @PutMapping("/editarUser/{id}")
//    public ResponseEntity<?> editarDados(@PathVariable Integer id, @RequestBody JSONObject jsonObject) throws Exception{
//        try {
//            Usuario usuario = usuarioRepository.findById(id).orElseThrow();
//            DadoUsuario dadosUsuario = dadoUsuarioRepository.findById(id).orElseThrow();
//            adminService.updateUser(usuario, dadosUsuario,jsonObject);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        }catch(Exception e) {
//            throw new Exception(e);
//        }
//    }



}