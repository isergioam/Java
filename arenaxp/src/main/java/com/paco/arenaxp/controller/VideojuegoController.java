package com.paco.arenaxp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paco.arenaxp.entity.Videojuego;
import com.paco.arenaxp.service.VideojuegoService;

// Indicamos que esta clase es un controlador REST.
@RestController

// Ruta base para este controlador.
@RequestMapping("/api/videojuegos")
public class VideojuegoController {

    private final VideojuegoService videojuegoService;

    // Inyección de dependencias por constructor.
    public VideojuegoController(VideojuegoService videojuegoService) {
        this.videojuegoService = videojuegoService;
    }

    // Endpoint GET que devuelve la lista de videojuegos.
    @GetMapping
    public List<Videojuego> listarVideojuegos() {
        return videojuegoService.listarVideojuegos();
    }
}