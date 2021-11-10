package com.blubank.repository;

import com.blubank.model.Movimento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentoRepository extends JpaRepository<Movimento, Integer> {
}
