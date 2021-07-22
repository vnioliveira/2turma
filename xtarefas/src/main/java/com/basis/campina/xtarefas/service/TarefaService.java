package com.basis.campina.xtarefas.service;

import com.basis.campina.xtarefas.domain.Tarefa;
import com.basis.campina.xtarefas.repository.TarefaRepository;
import com.basis.campina.xtarefas.service.dto.TarefaDTO;
import com.basis.campina.xtarefas.service.event.TarefaEvent;
import com.basis.campina.xtarefas.service.mapper.TarefaMapper;
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
@RequiredArgsConstructor(onConstructor_ ={@Lazy,@Autowired})
@Slf4j
public class TarefaService {

    private final TarefaMapper mapper;

    private final TarefaRepository repository;

    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional(readOnly = true)
    public TarefaDTO obterPorId(Long id) {
        return mapper.toDto(repository.getById(id));
    }

    public TarefaDTO editar(TarefaDTO tarefaDTO) {
        Tarefa tarefa = mapper.toEntity(tarefaDTO);
        repository.save(tarefa);
        return mapper.toDto(tarefa);
    }

    public List<TarefaDTO> listar() {
        List<Tarefa> tarefas = repository.findAll();
        return mapper.toListagemDto(tarefas);
    }

    public void remover(Long id) {
        Tarefa tarefa = mapper.toEntity(obterPorId(id));
        repository.delete(tarefa);
    }

    public TarefaDTO salvar(TarefaDTO dto){
        Tarefa tarefa = repository.save(mapper.toEntity(dto));
        applicationEventPublisher.publishEvent(new TarefaEvent(tarefa.getId()));
        return mapper.toDto(tarefa);
    }
}
