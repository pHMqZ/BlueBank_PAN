package com.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluebank.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer>{
}
