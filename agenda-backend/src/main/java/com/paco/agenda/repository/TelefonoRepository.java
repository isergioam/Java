package com.paco.agenda.repository;

import com.paco.agenda.model.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefonoRepository extends JpaRepository<Telefono, Long> {
}