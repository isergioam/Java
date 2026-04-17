package com.paco.agenda.service;

import com.paco.agenda.dto.ContactoResponseDTO;

import java.util.List;

public interface ContactoService {

    List<ContactoResponseDTO> listarTodos();

    ContactoResponseDTO obtenerPorId(Long id);

    ContactoResponseDTO crear(com.paco.agenda.dto.ContactoRequestDTO request);

    ContactoResponseDTO actualizar(Long id, com.paco.agenda.dto.ContactoRequestDTO request);

    void eliminar(Long id);

    List<ContactoResponseDTO> buscar(String texto, Long categoriaId, Boolean soloFavoritos);

    ContactoResponseDTO cambiarFavorito(Long id, Boolean favorito);
}