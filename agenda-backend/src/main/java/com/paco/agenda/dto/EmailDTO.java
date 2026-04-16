package com.paco.agenda.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmailDTO {

    @NotBlank(message = "La dirección de email es obligatoria")
    @Email(message = "El formato del email no es válido")
    private String direccion;

    @NotBlank(message = "El tipo de email es obligatorio")
    private String tipo;

    public EmailDTO() {
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}