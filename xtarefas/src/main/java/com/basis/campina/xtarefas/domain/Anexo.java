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

@Entity
@Table(name = "TB_ANEXO")
@Getter
@Setter
public class Anexo implements Serializable {

    @Id
    @Column(name = "CO_ANEXO", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ANEXO")
    @SequenceGenerator(name = "SQ_ANEXO", sequenceName = "SQ_ANEXO", allocationSize = 1)
    private Long id;

    @Column(name = "NO_FILE", nullable = false)
    private String file;

    @Column(name = "NO_FILENAME", nullable = false)
    private String fileName;

    @OneToOne
    @JoinColumn(name = "CO_TAREFA")
    private Tarefa tarefa;

    @Column(name = "NU_UUID")
    private String uuid;
}
