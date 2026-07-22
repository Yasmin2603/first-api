package com.yasmin.first_api.dto;

import jakarta.validation.constraints.Email;

public record UpdateCliente(
        String name,

        @Email(message = "O e-mail informado deve ser um endereço válido.")
        String email
) {}
