package com.paco.arenaxp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paco.arenaxp.entity.Videojuego;

// Este repositorio hereda operaciones CRUD básicas de JpaRepository.
public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
}