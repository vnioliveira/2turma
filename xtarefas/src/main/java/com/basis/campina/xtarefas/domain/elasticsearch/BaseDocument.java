package com.basis.campina.xtarefas.domain.elasticsearch;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.io.Serializable;

@Getter
@Setter
@Setting(settingPath = "/config/elastic/config.json")
public class BaseDocument implements Serializable {

    private static final long serialVersionUID = -5347593404772778083L;

    protected static final String TRIM_CASE_INSENSITIVE = "trim_case_insensitive";
    protected static final String SORT = "sort";
    protected static final String DATE_PATTERN = "dd/MM/yyyy";

    @MultiField(mainField = @Field(type = FieldType.Long, store = true),
            otherFields = {@InnerField(suffix = SORT,type = FieldType.Long, store = true)})
    protected Long id;
}
