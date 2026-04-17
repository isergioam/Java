package com.paco.agenda.repository;

import com.paco.agenda.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {

    List<Contacto> findByNombreContainingIgnoreCaseOrApellidosContainingIgnoreCase(String nombre, String apellidos);

    List<Contacto> findByCategoriaId(Long categoriaId);

    List<Contacto> findByFavoritoTrue();

    List<Contacto> findByNombreContainingIgnoreCaseOrApellidosContainingIgnoreCaseAndFavoritoTrue(String nombre, String apellidos);
}