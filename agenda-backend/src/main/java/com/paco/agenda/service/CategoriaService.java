package com.paco.agenda.service;

import com.paco.agenda.dto.CategoriaRequestDTO;
import com.paco.agenda.dto.CategoriaResponseDTO;

import java.util.List;

public interface CategoriaService {

    List<CategoriaResponseDTO> listarTodas();

    CategoriaResponseDTO obtenerPorId(Long id);

    CategoriaResponseDTO crear(CategoriaRequestDTO request);

    CategoriaResponseDTO actualizar(Long id, CategoriaRequestDTO request);

    void eliminar(Long id);
}