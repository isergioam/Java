package com.paco.agenda.service;

import com.paco.agenda.dto.ContactoRequestDTO;
import com.paco.agenda.dto.ContactoResponseDTO;

import java.util.List;

public interface ContactoService {

    List<ContactoResponseDTO> listarTodos();

    ContactoResponseDTO obtenerPorId(Long id);

    ContactoResponseDTO crear(ContactoRequestDTO request);
}