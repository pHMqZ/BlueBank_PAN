package com.blubank.repository;

import com.blubank.model.Conta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Integer>{
}
