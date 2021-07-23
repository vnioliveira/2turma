
package com.basis.campina.xtarefas.repository.elastic;

import com.basis.campina.xtarefas.domain.elasticsearch.ResponsavelDocument;

public interface ResponsavelSearchRepository extends ElasticEntity<ResponsavelDocument, Long> {

    @Override
    default Class<ResponsavelDocument> getEntityClass(){
        return ResponsavelDocument.class;
    }

}