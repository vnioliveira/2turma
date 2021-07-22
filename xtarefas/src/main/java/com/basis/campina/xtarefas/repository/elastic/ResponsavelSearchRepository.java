
package com.basis.campina.xtarefas.repository.elastic;

import com.basis.campina.xtarefas.domain.elasticsearch.ResponsavelDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ResponsavelSearchRepository extends ElasticsearchRepository<ResponsavelDocument, Long> {
}