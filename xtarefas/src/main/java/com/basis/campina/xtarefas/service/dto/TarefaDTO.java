package com.basis.campina.xtarefas.service.dto;

import com.basis.campina.xtarefas.domain.Anexo;
import com.basis.campina.xtarefas.domain.Responsavel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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
