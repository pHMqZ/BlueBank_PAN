package com.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluebank.model.Usuario;
																   
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer>{

}
