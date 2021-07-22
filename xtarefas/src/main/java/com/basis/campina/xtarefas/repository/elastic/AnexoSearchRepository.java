package com.basis.campina.xtarefas.repository.elastic;

import com.basis.campina.xtarefas.domain.elasticsearch.AnexoDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AnexoSearchRepository extends ElasticsearchRepository<AnexoDocument, Long> {
}