package com.basis.campina.xtarefas.web.rest;

import com.basis.campina.xtarefas.domain.elasticsearch.TarefaDocument;
import com.basis.campina.xtarefas.service.TarefaService;
import com.basis.campina.xtarefas.service.dto.TarefaDTO;
import com.basis.campina.xtarefas.service.filter.TarefaFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tarefa")
@RequiredArgsConstructor
public class TarefaResource {

    private final TarefaService service;

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> listar(){
        List<TarefaDTO> list = service.listar();
        if(list.isEmpty())
            return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> obterPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> salvar(@Valid @RequestBody TarefaDTO entidadeDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(entidadeDTO));
    }

    @PutMapping
    public ResponseEntity<TarefaDTO> editar(@Valid @RequestBody TarefaDTO entidadeDTO){
        return ResponseEntity.ok().body(service.editar(entidadeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        service.remover(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/pesquisar")
    public ResponseEntity<Page<TarefaDocument>> pesquisar(@RequestBody TarefaFilter filter, Pageable pageable){
        return ResponseEntity.ok(service.pesquisar(filter,pageable));
    }

}
