package com.basis.campina.xtarefas.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class AnexoDTO implements Serializable {

    private Long id;

    private String file;

    @NotNull
    private String fileName;
    @NotNull
    private Long idTarefa;

    private String uuid;
}
