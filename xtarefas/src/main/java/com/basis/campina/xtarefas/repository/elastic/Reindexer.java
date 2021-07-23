package com.basis.campina.xtarefas.repository.elastic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Reindexer {

    <T>Page<T> reindexPage(Pageable pageable);

    default String getEntity(){
        throw new IllegalAccessError("Metodo não implementado");
    }

}
