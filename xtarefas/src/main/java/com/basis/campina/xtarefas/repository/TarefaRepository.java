package com.basis.campina.xtarefas.repository;

import com.basis.campina.xtarefas.domain.Tarefa;
import com.basis.campina.xtarefas.domain.elasticsearch.TarefaDocument;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    Tarefa getById(Long id);

    @Query("select new com.basis.campina.xtarefas.domain.elasticsearch.TarefaDocument("
            + "t.id, t.nome, t.dataConclusao, t.dataInicio,t.status,t.responsavel) from Tarefa t where t.id = :id")
    TarefaDocument getDocument(@Param("id") Long id);
}
