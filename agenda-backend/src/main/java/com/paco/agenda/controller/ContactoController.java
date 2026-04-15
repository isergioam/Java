package com.paco.agenda.controller;

import com.paco.agenda.model.Contacto;
import com.paco.agenda.model.Email;
import com.paco.agenda.model.Telefono;
import com.paco.agenda.repository.ContactoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contactos")
public class ContactoController {

    private final ContactoRepository contactoRepository;

    public ContactoController(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    @GetMapping
    public List<Contacto> listarTodos() {
        return contactoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contacto> obtenerPorId(@PathVariable Long id) {
        Optional<Contacto> contacto = contactoRepository.findById(id);
        return contacto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contacto crear(@RequestBody Contacto contacto) {

        for (Telefono telefono : contacto.getTelefonos()) {
            telefono.setContacto(contacto);
        }

        for (Email email : contacto.getEmails()) {
            email.setContacto(contacto);
        }

        return contactoRepository.save(contacto);
    }
}