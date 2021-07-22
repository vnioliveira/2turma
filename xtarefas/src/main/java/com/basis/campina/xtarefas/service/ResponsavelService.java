package com.basis.campina.xtarefas.service;

import com.basis.campina.xtarefas.domain.Responsavel;
import com.basis.campina.xtarefas.repository.ResponsavelRepository;
import com.basis.campina.xtarefas.service.dto.ResponsavelDTO;
import com.basis.campina.xtarefas.service.event.ResponsavelEvent;
import com.basis.campina.xtarefas.service.mapper.ResponsavelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
@Slf4j
public class ResponsavelService {

    private final ResponsavelRepository repository;
    private final ResponsavelMapper mapper;
    private final ApplicationEventPublisher applicationEventPublisher;

    public ResponsavelDTO salvar(ResponsavelDTO dto){
        Responsavel responsavel = repository.save(mapper.toEntity(dto));
        applicationEventPublisher.publishEvent(new ResponsavelEvent(responsavel.getId()));
        return mapper.toDto(responsavel);
    }

    @Transactional(readOnly = true)
    public ResponsavelDTO buscarPorId(Long id){
        return mapper.toDto(repository.getById(id));
    }

    @Transactional(readOnly = true)
    public List<ResponsavelDTO> buscarTodos(){

        return mapper.toListagemDto(repository.findAll());
    }

    public void remover(Long id){
        repository.deleteById(id);
    }

    public ResponsavelDTO editar(ResponsavelDTO dto){
        this.buscarPorId(dto.getId());
        return this.salvar(dto);
    }

}
