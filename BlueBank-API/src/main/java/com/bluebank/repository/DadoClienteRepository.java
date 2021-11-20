package com.bluebank.repository;

import com.bluebank.model.DadoUsuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DadoClienteRepository extends JpaRepository<DadoUsuario, Integer> {
}
