package com.basis.campina.xtarefas.service.dto;

import liquibase.pro.packaged.I;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class AnexoDTO implements Serializable {
    private Long id;

    private String file;

    private String fileName;

    private Long idTarefa;
}
