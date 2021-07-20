package com.basis.campina.xtarefas.repository;

import com.basis.campina.xtarefas.domain.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {
}
