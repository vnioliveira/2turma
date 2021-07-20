package com.basis.campina.xtarefas.service.mapper;

import com.basis.campina.xtarefas.domain.Responsavel;
import com.basis.campina.xtarefas.domain.Tarefa;
import com.basis.campina.xtarefas.service.dto.ResponsavelDTO;
import com.basis.campina.xtarefas.service.dto.TarefaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResponsavelMapper {

    Responsavel toEntity(ResponsavelDTO dto);

    ResponsavelDTO toDto(Responsavel entity);

    List<ResponsavelDTO> toListagemDto(List<Responsavel> responsavels);
}
