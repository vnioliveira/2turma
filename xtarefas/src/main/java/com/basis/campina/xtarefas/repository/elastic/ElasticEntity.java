package com.basis.campina.xtarefas.repository.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticEntity <T , ID> extends ElasticsearchRepository <T ,ID> {
    Class<T> getEntityClass();
}
