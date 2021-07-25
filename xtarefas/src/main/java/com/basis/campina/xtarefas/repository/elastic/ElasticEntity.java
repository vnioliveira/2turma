package com.basis.campina.xtarefas.repository.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ElasticEntity <T , ID> extends ElasticsearchRepository <T ,ID> {
    Class<T> getEntityClass();
}
