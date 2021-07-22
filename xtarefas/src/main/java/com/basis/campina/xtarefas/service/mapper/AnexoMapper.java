package com.basis.campina.xtarefas.service.mapper;

import com.basis.campina.xtarefas.domain.Anexo;
import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnexoMapper {

    @Mapping(target = "tarefa.id",source = "idTarefa")
    Anexo toEntity(AnexoDTO dto);

    @Mapping(target = "idTarefa",source = "tarefa.id")
    AnexoDTO toDto(Anexo entity);

    List<AnexoDTO> toListagemDTO(List<Anexo> anexos);
}
