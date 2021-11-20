package com.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluebank.model.Movimento;

public interface MovimentoRepository extends JpaRepository<Movimento, Integer> {
}
