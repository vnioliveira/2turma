package com.basis.campina.xtarefas.service;

import com.basis.campina.xtarefas.domain.Anexo;
import com.basis.campina.xtarefas.domain.elasticsearch.AnexoDocument;
import com.basis.campina.xtarefas.repository.AnexoRepository;
import com.basis.campina.xtarefas.repository.elastic.AnexoSearchRepository;
import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import com.basis.campina.xtarefas.service.event.AnexoEvent;
import com.basis.campina.xtarefas.service.feign.DocumentClient;
import com.basis.campina.xtarefas.service.filter.AnexoFilter;
import com.basis.campina.xtarefas.service.mapper.AnexoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ ={@Lazy,@Autowired})
@Slf4j
public class AnexoService {



    private final AnexoMapper mapper;

    private final AnexoRepository repository;

    private final DocumentClient documentClient;

    private final ApplicationEventPublisher applicationEventPublisher;

    private final AnexoSearchRepository anexoSearchRepository;

    public AnexoDTO salvar(AnexoDTO dto){
        dto.setUuid(UUID.randomUUID().toString());
        Anexo anexo = repository.save(mapper.toEntity(dto));
        applicationEventPublisher.publishEvent(new AnexoEvent(anexo.getId()));
        return mapper.toDto(anexo);
    }

    @Transactional(readOnly = true)
    public AnexoDTO buscarPorId(Long id){
        AnexoDTO anexoDTO = mapper.toDto(repository.getById(id));
        documentClient.buscarDocument(anexoDTO.getFile());
        return anexoDTO;
    }

    @Transactional(readOnly = true)
    public List<AnexoDTO> buscarTodos(){
        return mapper.toListagemDTO(repository.findAll());
    }

    public void remover(Long id){
        AnexoDTO dto = this.buscarPorId(id);
        documentClient.deletarDocument(dto.getFile());
        repository.deleteById(id);
    }

    public void editar(AnexoDTO dto){
        this.buscarPorId(dto.getId());
        this.salvar(dto);
    }

    public Page<AnexoDocument> pesquisar(AnexoFilter anexoFilter, Pageable pageable){
        return anexoSearchRepository.search(anexoFilter.getFilter(),pageable);
    }

}
