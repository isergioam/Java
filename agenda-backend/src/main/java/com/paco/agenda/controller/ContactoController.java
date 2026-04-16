package com.paco.agenda.controller;

import com.paco.agenda.dto.ContactoRequestDTO;
import com.paco.agenda.dto.ContactoResponseDTO;
import com.paco.agenda.service.ContactoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/contactos")
public class ContactoController {

    private final ContactoService contactoService;

    public ContactoController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    @GetMapping
    public List<ContactoResponseDTO> listarTodos() {
        return contactoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ContactoResponseDTO obtenerPorId(@PathVariable Long id) {
        return contactoService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactoResponseDTO crear(@Valid @RequestBody ContactoRequestDTO request) {
        return contactoService.crear(request);
    }
}