package com.basis.campina.xtarefas.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class ResponsavelDTO implements Serializable {
    private Long id;

    private String nome;

    private String email;

    private LocalDate dataNascimento;
}
