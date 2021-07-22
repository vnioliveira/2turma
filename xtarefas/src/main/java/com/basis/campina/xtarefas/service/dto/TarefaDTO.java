package com.basis.campina.xtarefas.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class TarefaDTO implements Serializable {

    private Long id;

    private String nome;

    private LocalDate dataConclusao;

    private LocalDate dataInicio;

    private Boolean status;

    private Long idResponsavel;

}
