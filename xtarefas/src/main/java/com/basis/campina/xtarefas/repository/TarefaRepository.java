package com.basis.campina.xtarefas.repository;

import com.basis.campina.xtarefas.domain.Tarefa;
import com.basis.campina.xtarefas.domain.elasticsearch.TarefaDocument;
import com.basis.campina.xtarefas.repository.elastic.Reindexer;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>, Reindexer {

    Tarefa getById(Long id);

    @Query("select new com.basis.campina.xtarefas.domain.elasticsearch.TarefaDocument("
            + "t.id, t.nome, t.dataConclusao, t.dataInicio, t.status, t.responsavel) from Tarefa t where t.id = :id")
    TarefaDocument getDocument(@Param("id") Long id);

    @Query("select new com.basis.campina.xtarefas.domain.elasticsearch.TarefaDocument("
            + "t.id, t.nome, t.dataConclusao, t.dataInicio, t.status, t.responsavel) from Tarefa t order by t.id")
    Page<TarefaDocument> reindexPage(Pageable pageable);

    @Override
    default String getEntity() {
        return "tarefa";
    }
}

