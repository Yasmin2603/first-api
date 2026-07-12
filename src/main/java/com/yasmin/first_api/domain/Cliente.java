package com.yasmin.first_api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Cliente {
    long id;
    String email;
    String nome;
    LocalDate dataCadastro;
}
