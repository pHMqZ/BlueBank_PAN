package com.blubank.repository;

import com.blubank.model.DadoCliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DadoClienteRepository extends JpaRepository<DadoCliente, Integer> {
}
