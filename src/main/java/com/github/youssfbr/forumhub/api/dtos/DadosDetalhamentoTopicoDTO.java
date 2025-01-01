package com.github.youssfbr.forumhub.api.dtos;

import com.github.youssfbr.forumhub.domains.topicos.Topico;

public record DadosDetalhamentoTopicoDTO(
        Long id ,
        String titulo ,
        String mensagem ,
        String dataCriacao
) {
    public DadosDetalhamentoTopicoDTO(Topico topico) {
        this(
                topico.getId() ,
                topico.getTitulo() ,
                topico.getMensagem() ,
                topico.getDataCriacao().toString()
        );
    }
}
