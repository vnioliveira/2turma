package com.basis.campina.xtarefas.web.rest;

import com.basis.campina.xtarefas.service.AnexoService;
import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/anexo")
@RequiredArgsConstructor
@Slf4j
public class AnexoResource {

    private final AnexoService service;

    @GetMapping
    public ResponseEntity<List<AnexoDTO>> buscarTodos(){
        log.debug("Requisição REST request para buscar todos os Anexo");
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnexoDTO> buscarPorId(@PathVariable Long id){
        log.debug("Requisição REST request para buscar Anexo por id");
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody AnexoDTO anexoDTO){
        log.debug("Requisição REST request para salvar Anexo:", anexoDTO);
        service.salvar(anexoDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<Void> editar(@RequestBody AnexoDTO anexoDTO){
        log.debug("Requisição REST request para editar Anexo:", anexoDTO);
        service.editar(anexoDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id){
        log.debug("Requisição REST request para deletar Anexo por id");
        service.remover(id);
        return ResponseEntity.ok().build();
    }




}
