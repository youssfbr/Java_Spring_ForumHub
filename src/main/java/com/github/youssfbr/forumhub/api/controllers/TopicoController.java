package com.github.youssfbr.forumhub.api.controllers;

import com.github.youssfbr.forumhub.api.dtos.DadosCadastroTopico;
import com.github.youssfbr.forumhub.api.dtos.DadosDetalhamentoTopicoDTO;
import com.github.youssfbr.forumhub.domains.topicos.ITopicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    private final ITopicoService topicoService;

    public TopicoController(ITopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @GetMapping
    public String ok() {
        return "OK";
    }

    @PostMapping
    public ResponseEntity<DadosDetalhamentoTopicoDTO> cadastrar(@RequestBody DadosCadastroTopico dados) {
        final DadosDetalhamentoTopicoDTO topicoCadastrado = topicoService.salvarTopico(dados);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(topicoCadastrado.id()).toUri();

        //return ResponseEntity.ok(dados);
        return ResponseEntity.created(uri).body(topicoCadastrado);
    }

}
