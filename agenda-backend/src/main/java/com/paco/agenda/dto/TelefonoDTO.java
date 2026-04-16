package com.paco.agenda.dto;

import jakarta.validation.constraints.NotBlank;

public class TelefonoDTO {

    @NotBlank(message = "El número de teléfono es obligatorio")
    private String numero;

    @NotBlank(message = "El tipo de teléfono es obligatorio")
    private String tipo;

    public TelefonoDTO() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}