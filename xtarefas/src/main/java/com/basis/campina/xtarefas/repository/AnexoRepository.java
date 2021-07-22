package com.basis.campina.xtarefas.repository;

import com.basis.campina.xtarefas.domain.Anexo;
import com.basis.campina.xtarefas.domain.elasticsearch.AnexoDocument;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnexoRepository extends JpaRepository<Anexo, Long> {
    Anexo getById(Long id);

    @Query("select new com.basis.campina.xtarefas.domain.elasticsearch.AnexoDocument("
            + "a.id, a.file, a.fileName, a.tarefa, a.uuid) from Anexo a where a.id = :id")
    AnexoDocument getDocument(@Param("id") Long id);
}
