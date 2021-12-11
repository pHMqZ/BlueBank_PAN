package com.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluebank.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer>{

}
