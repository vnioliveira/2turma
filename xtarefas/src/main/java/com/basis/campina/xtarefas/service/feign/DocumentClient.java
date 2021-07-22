package com.basis.campina.xtarefas.service.feign;

import com.basis.campina.xtarefas.service.dto.AnexoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "xdocs", url = "${application.feign.url-documents}")
public interface DocumentClient {

    @GetMapping("api/arquivos/{uuid}")
    String buscarDocument(@PathVariable("uuid") String uuid);

    @PostMapping("api/arquivos")
    String salvar(AnexoDTO anexoDTO);

    @DeleteMapping("api/arquivos/{uuid}")
    void deletarDocument(@PathVariable("uuid") String uuid);

}
