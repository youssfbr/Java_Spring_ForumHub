package com.github.youssfbr.forumhub.domains.topicos.dtos;

import com.github.youssfbr.forumhub.domains.respostas.dtos.DadosRespostaDTO;
import com.github.youssfbr.forumhub.domains.topicos.Topico;
import com.github.youssfbr.forumhub.domains.topicos.enums.TopicoStatus;

import java.util.List;

public record DadosDetalhamentoTopicoDTO(
        Long id ,
        String titulo ,
        String mensagem ,
        String dataCriacao ,
        TopicoStatus status ,
        String nomeAutor ,
        String nomeCurso ,
        List<DadosRespostaDTO> respostas
) {
    public DadosDetalhamentoTopicoDTO(Topico topico) {
        this(
                topico.getId() ,
                topico.getTitulo() ,
                topico.getMensagem() ,
                topico.getDataCriacao().toString() ,
                topico.getStatus() ,
                topico.getAutor() ,
                topico.getCurso() ,

                topico.getResposta()
                        .stream()
                        .map(DadosRespostaDTO::new)
                        .toList()
        );
    }
}
