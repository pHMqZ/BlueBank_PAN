package com.bluebank.repository;

import com.bluebank.model.Movimento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentoRepository extends JpaRepository<Movimento, Integer> {
}
