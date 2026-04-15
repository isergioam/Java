package com.paco.agenda.repository;

import com.paco.agenda.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositorio para trabajar con Contacto
public interface ContactoRepository extends JpaRepository<Contacto, Long> {
}