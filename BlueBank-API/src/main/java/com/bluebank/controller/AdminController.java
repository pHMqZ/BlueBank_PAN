package com.bluebank.controller;

import com.bluebank.dto.UsuarioDto;
import com.bluebank.dto.UsuarioResposta;
import com.bluebank.model.DadoUsuario;
import com.bluebank.model.Usuario;
import com.bluebank.repository.AgenciaRepository;
import com.bluebank.repository.DadoUsuarioRepository;
import com.bluebank.repository.MovimentoRepository;
import com.bluebank.repository.UsuarioRepository;
import com.bluebank.service.AdminService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class AdminController {
    //Funções do Admin
//    Escopo = Usuário
    //    - Cadastrar Admin
    //    - Listar usuário(s)
    //    - Editar usuário(s)
    //    - Bloquear usuário(s)
    //    - Desbloquear usuário(s)
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
    private AgenciaRepository agenciaRepository;
    @Autowired
    private MovimentoRepository movimentoRepository;


    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("/salvar")
    public ResponseEntity<UsuarioResposta> cadastrarAdmin(@RequestBody UsuarioDto usuarioDto){
        Usuario usuario = adminService.cadastrarAdmin(usuarioDto.transformaAdmin());
        return new ResponseEntity<>(UsuarioResposta.transformaDTOAdmin(usuario), HttpStatus.CREATED);
    }

    @GetMapping("/listarUsuarios")
    public List<UsuarioResposta> userFindAll(){
        var user = adminService.userFindAll();
        return user.stream().map(UsuarioResposta::transformaDTO).collect(Collectors.toList());
    }
    @GetMapping("/listarUsuarioId")
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