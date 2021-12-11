package com.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluebank.model.Agencia;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Integer>{
}
