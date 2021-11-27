package com.bluebank.service;

import com.bluebank.model.Agencia;
import com.bluebank.model.DadoUsuario;
import com.bluebank.model.Movimento;
import com.bluebank.model.Usuario;
import com.bluebank.repository.AgenciaRepository;
import com.bluebank.repository.DadoUsuarioRepository;
import com.bluebank.repository.MovimentoRepository;
import com.bluebank.repository.UsuarioRepository;
import org.json.simple.JSONObject;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class AdminService {
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
//########################################################################################

//Parametros e contrutores

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AgenciaRepository agenciaRepository;

    @Autowired
    private MovimentoRepository movimentoRepository;

    @Autowired
    private DadoUsuarioRepository dadoUsuarioRepository;


    public AdminService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public AdminService(AgenciaRepository agenciaRepository) {
        this.agenciaRepository = agenciaRepository;
    }

    public AdminService(MovimentoRepository movimentoRepository) {
        this.movimentoRepository = movimentoRepository;
    }

//USUARIOS

    public Usuario cadastrarAdmin(Usuario usuario){
        usuario.setAdmin(true);
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public List<Usuario> userFindAll(){
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Usuario userFindById(Integer id){
        return usuarioRepository.findById(id).get();
    }

    public void updateUser( Usuario usuario, DadoUsuario dado, JSONObject jsonObject) throws Exception {
        String nome;
        String senha;
        String cpf;
        Integer telefone;
        String email;
        String bairro;
        String complemento;
        String rua;
        String estado;
        String cidade;

        try {
            nome = (String) jsonObject.get("nome");
            senha = (String) jsonObject.get("senha");
            cpf = (String) jsonObject.get("cpf");
            telefone = (Integer) jsonObject.get("telefone");
            email = (String) jsonObject.get("email");
            bairro = (String) jsonObject.get("bairro");
            complemento = (String) jsonObject.get("complemento");
            rua = (String) jsonObject.get("rua");
            estado = (String) jsonObject.get("estado");
            cidade = (String) jsonObject.get("cidade");

            usuario.setNome(nome);
            usuario.setSenha(senha);
            dado.setCpf(cpf);
            dado.setTelefone(telefone);
            dado.setEmail(email);
            dado.setBairro(bairro);
            dado.setComplemento(complemento);
            dado.setRua(rua);
            dado.setEstado(estado);
            dado.setCidade(cidade);

            usuarioRepository.save(usuario);
            dadoUsuarioRepository.save(dado);
        }catch(Exception e) {
            throw new Exception(e);
        }
    }

    public Usuario bloqueiaUser(Integer id){
        Usuario usuario = usuarioRepository.getById(id);
        usuario.setStatus(false);
        return usuario;
    }
    public Usuario desbloqueiaUser(Integer id){
        Usuario usuario = usuarioRepository.getById(id);
        usuario.setStatus(true);
        return usuario;
    }
    //########################################################################################
//AGENCIA
    public Agencia CriarAgencia(Agencia agencia){
        return agenciaRepository.save(agencia);
    }
    public void desativaAgencia(Agencia agencia){
        agencia = agenciaRepository.getById(agencia.getId());
        agencia.setStatus(false);
    }
    public void ativaAgencia(Agencia agencia){
        agencia = agenciaRepository.getById(agencia.getId());
        agencia.setStatus(true);
    }
    public void updateAgencia(@PathVariable Integer id, Agencia agencia) throws Exception{
        var ag = agenciaRepository.findById(id);

        if(ag.isPresent()){
            var agUpdate = agencia;
            agencia.setNome(agencia.getNome());
            agenciaRepository.save(agUpdate);
        }else{
            throw new Exception("Agencia nao cadastrada");
        }
    }
    @Transactional(readOnly = true)
    public List<Agencia> listarAllAgencias(){
        return agenciaRepository.findAll();
    }
    //########################################################################################
//MOVIMENTO
    public Movimento movimentoFindById(Integer id){
        return movimentoRepository.findById(id).get();
    }
    public List<Movimento> movimentoFindAll(){
        return movimentoRepository.findAll();
    }
























}
