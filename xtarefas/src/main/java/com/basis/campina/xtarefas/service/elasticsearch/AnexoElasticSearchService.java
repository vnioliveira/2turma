package com.basis.campina.xtarefas.service.elasticsearch;

import com.basis.campina.xtarefas.domain.elasticsearch.AnexoDocument;
import com.basis.campina.xtarefas.domain.elasticsearch.TarefaDocument;
import com.basis.campina.xtarefas.repository.AnexoRepository;
import com.basis.campina.xtarefas.repository.TarefaRepository;
import com.basis.campina.xtarefas.repository.elastic.AnexoSearchRepository;
import com.basis.campina.xtarefas.repository.elastic.TarefaSearchRepository;
import com.basis.campina.xtarefas.service.event.AnexoEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AnexoElasticSearchService {

    private final AnexoRepository anexoRepository;
    private final AnexoSearchRepository anexoSearchRepository;

    @TransactionalEventListener(fallbackExecution = true)
    public void reindex(AnexoEvent anexoEvent) {
        log.debug("Iniciando indexação do Anexo a partir de: {}", anexoEvent.getId());
        AnexoDocument anexoDocument = anexoRepository.getDocument(anexoEvent.getId());
        anexoSearchRepository.save(anexoDocument);
    }
}
