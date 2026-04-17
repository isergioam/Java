package com.paco.agenda.service.impl;

import com.paco.agenda.dto.ContactoRequestDTO;
import com.paco.agenda.dto.ContactoResponseDTO;
import com.paco.agenda.dto.EmailDTO;
import com.paco.agenda.dto.TelefonoDTO;
import com.paco.agenda.exception.ResourceNotFoundException;
import com.paco.agenda.model.Categoria;
import com.paco.agenda.model.Contacto;
import com.paco.agenda.model.Email;
import com.paco.agenda.model.Telefono;
import com.paco.agenda.repository.CategoriaRepository;
import com.paco.agenda.repository.ContactoRepository;
import com.paco.agenda.service.ContactoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoServiceImpl implements ContactoService {

    private final ContactoRepository contactoRepository;
    private final CategoriaRepository categoriaRepository;

    public ContactoServiceImpl(ContactoRepository contactoRepository,
                               CategoriaRepository categoriaRepository) {
        this.contactoRepository = contactoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<ContactoResponseDTO> listarTodos() {
        return contactoRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public ContactoResponseDTO obtenerPorId(Long id) {
        Contacto contacto = contactoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el contacto con id " + id));

        return toResponseDTO(contacto);
    }

    @Override
    public ContactoResponseDTO crear(ContactoRequestDTO request) {
        Categoria categoria = categoriaRepository.findById(request.getCategoriaId())
                .orElseThrow(() -> new ResourceNotFoundException("No existe la categoría con id " + request.getCategoriaId()));

        Contacto contacto = new Contacto();
        contacto.setNombre(request.getNombre());
        contacto.setApellidos(request.getApellidos());
        contacto.setFavorito(request.getFavorito());
        contacto.setCategoria(categoria);

        List<Telefono> telefonos = request.getTelefonos().stream().map(t -> {
            Telefono telefono = new Telefono();
            telefono.setNumero(t.getNumero());
            telefono.setTipo(t.getTipo());
            telefono.setContacto(contacto);
            return telefono;
        }).toList();

        List<Email> emails = request.getEmails().stream().map(e -> {
            Email email = new Email();
            email.setDireccion(e.getDireccion());
            email.setTipo(e.getTipo());
            email.setContacto(contacto);
            return email;
        }).toList();

        contacto.setTelefonos(telefonos);
        contacto.setEmails(emails);

        return toResponseDTO(contactoRepository.save(contacto));
    }
    
    @Override
    public List<ContactoResponseDTO> buscar(String texto, Long categoriaId, Boolean soloFavoritos) {
        List<Contacto> contactos = contactoRepository.findAll();

        return contactos.stream()
                .filter(c -> texto == null || texto.isBlank() ||
                        c.getNombre().toLowerCase().contains(texto.toLowerCase()) ||
                        c.getApellidos().toLowerCase().contains(texto.toLowerCase()))
                .filter(c -> categoriaId == null ||
                        (c.getCategoria() != null && c.getCategoria().getId().equals(categoriaId)))
                .filter(c -> soloFavoritos == null || !soloFavoritos || Boolean.TRUE.equals(c.getFavorito()))
                .map(this::toResponseDTO)
                .toList();
    }

    private ContactoResponseDTO toResponseDTO(Contacto contacto) {
        ContactoResponseDTO dto = new ContactoResponseDTO();
        dto.setId(contacto.getId());
        dto.setNombre(contacto.getNombre());
        dto.setApellidos(contacto.getApellidos());
        dto.setFavorito(contacto.getFavorito());
        dto.setCategoriaId(contacto.getCategoria().getId());
        dto.setCategoriaNombre(contacto.getCategoria().getNombre());

        dto.setTelefonos(contacto.getTelefonos().stream().map(t -> {
            TelefonoDTO telefonoDTO = new TelefonoDTO();
            telefonoDTO.setNumero(t.getNumero());
            telefonoDTO.setTipo(t.getTipo());
            return telefonoDTO;
        }).toList());

        dto.setEmails(contacto.getEmails().stream().map(e -> {
            EmailDTO emailDTO = new EmailDTO();
            emailDTO.setDireccion(e.getDireccion());
            emailDTO.setTipo(e.getTipo());
            return emailDTO;
        }).toList());

        return dto;
    }

	@Override
	public ContactoResponseDTO actualizar(Long id, ContactoRequestDTO request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ContactoResponseDTO cambiarFavorito(Long id, Boolean favorito) {
		// TODO Auto-generated method stub
		return null;
	}
}