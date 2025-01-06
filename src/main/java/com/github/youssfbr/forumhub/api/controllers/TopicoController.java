package com.github.youssfbr.forumhub.api.controllers;

import com.github.youssfbr.forumhub.domains.topicos.dtos.DadosCadastroTopico;
import com.github.youssfbr.forumhub.domains.topicos.dtos.DadosDetalhamentoTopicoDTO;
import com.github.youssfbr.forumhub.domains.topicos.dtos.DadosListagemTopico;
import com.github.youssfbr.forumhub.domains.topicos.ITopicoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<Page<DadosListagemTopico>> paginar(
            @PageableDefault(size = 10 , page = 0 , sort = {"dataCriacao"}) Pageable paginacao) {
        return ResponseEntity.ok(topicoService.paginar(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopicoDTO> detalhar(@PathVariable @NotNull @Positive Long id) {
        return ResponseEntity.ok(topicoService.detalhar(id));
    }

    @PostMapping
    public ResponseEntity<DadosDetalhamentoTopicoDTO> cadastrar(@Valid @RequestBody DadosCadastroTopico dados) {
        final DadosDetalhamentoTopicoDTO topicoCadastrado = topicoService.salvarTopico(dados);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(topicoCadastrado.id()).toUri();

        return ResponseEntity.created(uri).body(topicoCadastrado);
    }

}
