package com.basis.campina.xtarefas.web.rest;

import com.basis.campina.xtarefas.service.AnexoService;
import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/api/anexo")
@RequiredArgsConstructor
public class AnexoResource {

    private final AnexoService service;

    @GetMapping
    public ResponseEntity<List<AnexoDTO>> listar(){
        List<AnexoDTO> list = service.listar();
        if(list.isEmpty())
            return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnexoDTO> obterPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<AnexoDTO> salvar(@Valid @RequestBody AnexoDTO entidadeDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(entidadeDTO));
    }

    @PutMapping
    public ResponseEntity<AnexoDTO> editar(@Valid @RequestBody AnexoDTO entidadeDTO){
        return ResponseEntity.ok().body(service.editar(entidadeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        service.remover(id);
        return ResponseEntity.ok().build();
    }
}
