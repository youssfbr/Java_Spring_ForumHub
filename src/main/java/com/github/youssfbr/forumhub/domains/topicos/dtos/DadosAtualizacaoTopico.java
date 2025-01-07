package com.github.youssfbr.forumhub.domains.topicos.dtos;

import com.github.youssfbr.forumhub.domains.topicos.enums.TopicoStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoTopico(

        @NotNull
        @Positive
        Long id ,

        @Size(max = 100 , message = "No máximo 100 caracteres")
        String titulo ,

        @Size(max = 100 , message = "No máximo 100 caracteres")
        String mensagem ,

        TopicoStatus status ,

        @Size(max = 100 , message = "No máximo 100 caracteres")
        String nomeAutor ,

        @Size(max = 100 , message = "No máximo 100 caracteres")
        String nomeCurso
) {
}
