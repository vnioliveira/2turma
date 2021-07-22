package com.basis.campina.xtarefas.domain.elasticsearch;

import com.basis.campina.xtarefas.domain.Responsavel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Document(indexName = "index-tarefa")
@NoArgsConstructor
public class TarefaDocument extends BaseDocument {

    @MultiField(mainField = @Field(type = FieldType.Text,
            store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Text,
                    store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true)})
    private String nome;

    @MultiField(mainField = @Field(type = FieldType.Keyword, store = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Date,
                    store = true, format = DateFormat.custom, pattern = DATE_PATTERN)})
    private String dataConclusao;

    @MultiField(mainField = @Field(type = FieldType.Keyword, store = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Date,
                    store = true, format = DateFormat.custom, pattern = DATE_PATTERN)})
    private String dataInicio;

    @MultiField(mainField = @Field(type = FieldType.Text,
            store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Text,
                    store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true)})
    private String status;

    @MultiField(mainField = @Field(type = FieldType.Text,
            store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Text,
                    store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true)})
    private String responsavel;

    public TarefaDocument(Long id,String nome, LocalDate dataConclusao, LocalDate dataInicio, Boolean status, Responsavel responsavel) {
        this.id = id;
        this.nome = nome;
        this.dataConclusao = dataConclusao != null ?
                dataConclusao.format(DateTimeFormatter.ofPattern(DATE_PATTERN)) : null;

        this.dataInicio = dataInicio != null ?
                dataInicio.format(DateTimeFormatter.ofPattern(DATE_PATTERN)) : null;
        this.status = status.toString();
        this.responsavel = responsavel.getId().toString();
    }
}