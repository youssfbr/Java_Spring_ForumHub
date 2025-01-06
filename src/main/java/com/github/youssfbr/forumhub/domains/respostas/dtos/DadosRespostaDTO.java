package com.github.youssfbr.forumhub.domains.respostas.dtos;

import com.github.youssfbr.forumhub.domains.respostas.Resposta;

public record DadosRespostaDTO(
        Long id ,
        String mensagem ,
        String autor ,
        String solucao
) {
    public DadosRespostaDTO(Resposta resposta) {
        this(
                resposta.getId() ,
                resposta.getMensagem() ,
                resposta.getAutor() ,
                resposta.getSolucao()
        );
    }
}
