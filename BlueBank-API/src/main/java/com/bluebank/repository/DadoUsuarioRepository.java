package com.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluebank.model.DadoUsuario;
import org.springframework.stereotype.Repository;

@Repository
public interface DadoUsuarioRepository extends JpaRepository<DadoUsuario, Integer> {
}
