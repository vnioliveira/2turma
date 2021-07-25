package com.basis.campina.xtarefas.repository;

import com.basis.campina.xtarefas.domain.Anexo;
import com.basis.campina.xtarefas.domain.elasticsearch.AnexoDocument;
import com.basis.campina.xtarefas.repository.elastic.Reindexer;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnexoRepository extends JpaRepository<Anexo, Long>, Reindexer {

    Anexo getById(Long id);

    @Query("select new com.basis.campina.xtarefas.domain.elasticsearch.AnexoDocument("
            + "a.id, a.file, a.fileName, a.tarefa, a.uuid) from Anexo a where a.id = :id")
    AnexoDocument getDocument(@Param("id") Long id);

    @Query("select new com.basis.campina.xtarefas.domain.elasticsearch.AnexoDocument("
            + "a.id, a.file, a.fileName, a.tarefa, a.uuid) from Anexo a order by a.id")
    Page<AnexoDocument> reindexPage(Pageable pageable);

    @Override
    default String getEntity() {
        return "anexo";
    }
}
