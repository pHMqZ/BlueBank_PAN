package com.bluebank.repository;

import com.bluebank.model.Conta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Integer>{
}
