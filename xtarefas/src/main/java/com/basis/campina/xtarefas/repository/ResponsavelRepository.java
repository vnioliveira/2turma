package com.basis.campina.xtarefas.repository;

import com.basis.campina.xtarefas.domain.Anexo;
import com.basis.campina.xtarefas.domain.Responsavel;
import com.basis.campina.xtarefas.domain.elasticsearch.ResponsavelDocument;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {
    Responsavel getById(Long id);

    @Query("select new com.basis.campina.xtarefas.domain.elasticsearch.ResponsavelDocument("
            + "r.id, r.nome, r.email, r.dataNascimento) from Responsavel r where r.id = :id")
    ResponsavelDocument getDocument(@Param("id") Long id);

}
