package com.basis.campina.xtarefas.service;

import com.basis.campina.xtarefas.domain.Anexo;
import com.basis.campina.xtarefas.domain.Tarefa;
import com.basis.campina.xtarefas.repository.AnexoRepository;
import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import com.basis.campina.xtarefas.service.dto.TarefaDTO;
import com.basis.campina.xtarefas.service.mapper.AnexoMapper;
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
public class AnexoService {

    private final AnexoMapper mapper;

    private final AnexoRepository repository;

    @Transactional(readOnly = true)
    public AnexoDTO obterPorId(Long id) {
        return mapper.toDto(repository.getById(id));
    }

    public AnexoDTO editar(AnexoDTO anexoDTO) {
        Anexo anexo = mapper.toEntity(anexoDTO);
        repository.save(anexo);
        return mapper.toDto(anexo);
    }

    public List<AnexoDTO> listar() {
        List<Anexo> anexos = repository.findAll();
        return mapper.toListagemDto(anexos);
    }

    public void remover(Long id) {
        Anexo anexo = mapper.toEntity(obterPorId(id));
        repository.delete(anexo);
    }

    public AnexoDTO salvar(AnexoDTO anexoDTO) {
        Anexo anexo = mapper.toEntity(anexoDTO);
        repository.save(anexo);
        return mapper.toDto(anexo);
    }

}
