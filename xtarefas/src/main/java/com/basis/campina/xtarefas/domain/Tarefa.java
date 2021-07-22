package com.basis.campina.xtarefas.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "TB_TAREFA")
@Getter
@Setter
public class Tarefa implements Serializable {

    @Id
    @Column(name = "CO_TAREFA", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TAREFA")
    @SequenceGenerator(name = "SQ_TAREFA", sequenceName = "SQ_TAREFA", allocationSize = 1)
    private Long id;

    @Column(name = "NO_TAREFA", nullable = false)
    private String nome;

    @Column(name = "DT_DATACONCLUSAO", nullable = false)
    private LocalDate dataConclusao;

    @Column(name = "DT_DATAINICIO", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "BO_STATUS", nullable = false)
    private Boolean status;

    @OneToOne
    @JoinColumn(name ="CO_RESPONSAVEL")
    private Responsavel responsavel;
}
