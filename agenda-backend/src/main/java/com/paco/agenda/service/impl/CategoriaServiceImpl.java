package com.paco.agenda.service.impl;

import com.paco.agenda.dto.CategoriaRequestDTO;
import com.paco.agenda.dto.CategoriaResponseDTO;
import com.paco.agenda.exception.ResourceNotFoundException;
import com.paco.agenda.model.Categoria;
import com.paco.agenda.repository.CategoriaRepository;
import com.paco.agenda.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<CategoriaResponseDTO> listarTodas() {
        return categoriaRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public CategoriaResponseDTO obtenerPorId(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la categoría con id " + id));

        return toResponseDTO(categoria);
    }

    @Override
    public CategoriaResponseDTO crear(CategoriaRequestDTO request) {
        Categoria categoria = new Categoria();
        categoria.setNombre(request.getNombre());
        return toResponseDTO(categoriaRepository.save(categoria));
    }

    @Override
    public CategoriaResponseDTO actualizar(Long id, CategoriaRequestDTO request) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la categoría con id " + id));

        categoria.setNombre(request.getNombre());
        return toResponseDTO(categoriaRepository.save(categoria));
    }

    @Override
    public void eliminar(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new ResourceNotFoundException("No existe la categoría con id " + id);
        }

        categoriaRepository.deleteById(id);
    }

    private CategoriaResponseDTO toResponseDTO(Categoria categoria) {
        return new CategoriaResponseDTO(categoria.getId(), categoria.getNombre());
    }
}