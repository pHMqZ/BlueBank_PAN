package com.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluebank.model.DadoUsuario;

public interface DadoUsuarioRepository extends JpaRepository<DadoUsuario, Integer> {
}
