package com.basis.campina.xtarefas.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "TB_RESPONSAVEL")
@Getter
@Setter
public class Responsavel implements Serializable {

    @Id
    @Column(name = "CO_RESPONSAVEL", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RESPONSAVEL")
    @SequenceGenerator(name = "SQ_RESPONSAVEL", sequenceName = "SQ_RESPONSAVEL", allocationSize = 1)
    private Long id;

    @Column(name = "NO_RESPONSAVEL", nullable = false)
    private String nome;

    @Column(name = "NO_EMAIL", nullable = false)
    private String EMAIL;

    @Column(name = "DT_DATANASCIMENTO", nullable = false)
    private LocalDate dataNascimento;

}
