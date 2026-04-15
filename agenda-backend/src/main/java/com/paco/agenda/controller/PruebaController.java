package com.paco.agenda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Este controlador sirve solo para comprobar que la API funciona
@RestController
public class PruebaController {

    // Endpoint de prueba
    @GetMapping("/api/prueba")
    public String prueba() {
        return "Backend de Agenda funcionando correctamente";
    }
}