package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Eventos;

public interface EventosRepository extends JpaRepository<Eventos, Long> {
}