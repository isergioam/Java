package com.paco.agenda.repository;

import com.paco.agenda.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository nos da operaciones CRUD ya preparadas
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}