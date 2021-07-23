package com.basis.campina.xtarefas.web.rest;

import com.basis.campina.xtarefas.service.elasticsearch.ElasticSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/elasticsearch/reindex")
@RequiredArgsConstructor
public class ElasticsearchResource {

    private final ElasticSearchService service;
    @GetMapping
    public ResponseEntity<String> reindex(){
        this.service.reindex();
        return ResponseEntity.ok().body("Reideixando todo o elasticsearch");
    }

    @GetMapping("/{entity}")
    public ResponseEntity<String> reindex(@PathVariable("entity") String entity){
        this.service.reindexEntity(entity);
        return ResponseEntity.ok().body("Reideixando o elasticsearch");
    }
}
