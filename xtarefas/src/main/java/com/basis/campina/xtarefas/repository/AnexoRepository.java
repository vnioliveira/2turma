package com.basis.campina.xtarefas.repository;

import com.basis.campina.xtarefas.domain.Anexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnexoRepository extends JpaRepository<Anexo,Long> {
}
