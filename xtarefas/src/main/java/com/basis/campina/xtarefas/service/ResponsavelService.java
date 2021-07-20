package com.basis.campina.xtarefas.service;

import com.basis.campina.xtarefas.domain.Anexo;
import com.basis.campina.xtarefas.domain.Responsavel;
import com.basis.campina.xtarefas.repository.ResponsavelRepository;
import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import com.basis.campina.xtarefas.service.dto.ResponsavelDTO;
import com.basis.campina.xtarefas.service.dto.TarefaDTO;
import com.basis.campina.xtarefas.service.mapper.ResponsavelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ ={@Lazy,@Autowired})
@Slf4j
public class ResponsavelService {

    private final ResponsavelMapper mapper;

    private final ResponsavelRepository repository;

    @Transactional(readOnly = true)
    public ResponsavelDTO obterPorId(Long id) {
        return mapper.toDto(repository.getById(id));
    }

    public ResponsavelDTO editar(ResponsavelDTO responsavelDTO) {
        Responsavel responsavel = mapper.toEntity(responsavelDTO);
        repository.save(responsavel);
        return mapper.toDto(responsavel);
    }

    public List<ResponsavelDTO> listar() {
        List<Responsavel> responsavels = repository.findAll();
        return mapper.toListagemDto(responsavels);
    }

    public void remover(Long id) {
        Responsavel responsavel = mapper.toEntity(obterPorId(id));
        repository.delete(responsavel);
    }

    public ResponsavelDTO salvar(ResponsavelDTO responsavelDTO) {
        Responsavel responsavel = mapper.toEntity(responsavelDTO);
        repository.save(responsavel);
        return mapper.toDto(responsavel);
    }
}
