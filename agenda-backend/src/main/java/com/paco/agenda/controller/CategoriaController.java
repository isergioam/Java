package com.paco.agenda.controller;

import com.paco.agenda.dto.CategoriaRequestDTO;
import com.paco.agenda.dto.CategoriaResponseDTO;
import com.paco.agenda.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<CategoriaResponseDTO> listarTodas() {
        return categoriaService.listarTodas();
    }

    @GetMapping("/{id}")
    public CategoriaResponseDTO obtenerPorId(@PathVariable Long id) {
        return categoriaService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaResponseDTO crear(@Valid @RequestBody CategoriaRequestDTO request) {
        return categoriaService.crear(request);
    }

    @PutMapping("/{id}")
    public CategoriaResponseDTO actualizar(@PathVariable Long id,
                                           @Valid @RequestBody CategoriaRequestDTO request) {
        return categoriaService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        categoriaService.eliminar(id);
    }
}