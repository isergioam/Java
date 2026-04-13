package com.paco.arenaxp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paco.arenaxp.entity.Videojuego;
import com.paco.arenaxp.repository.VideojuegoRepository;

// Indicamos que esta clase pertenece a la capa de servicio.
@Service
public class VideojuegoService {

    // Repositorio que usaremos para acceder a la base de datos.
    private final VideojuegoRepository videojuegoRepository;

    // Inyección de dependencias por constructor.
    public VideojuegoService(VideojuegoRepository videojuegoRepository) {
        this.videojuegoRepository = videojuegoRepository;
    }

    // Método para listar todos los videojuegos.
    public List<Videojuego> listarVideojuegos() {
        return videojuegoRepository.findAll();
    }
}