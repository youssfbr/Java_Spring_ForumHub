package com.github.youssfbr.forumhub.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastroTopico(

        @NotBlank(message = "Título é obrigatório")
        @Size(max = 100 , message = "No máximo 100 caracteres")
        String titulo ,

        @NotBlank(message = "Mensagem é obrigatória")
        @Size(max = 100 , message = "No máximo 100 caracteres")
        String mensagem ,

        @NotBlank(message = "Nome do Autor é obrigatório")
        @Size(max = 100 , message = "No máximo 100 caracteres")
        String nomeAutor ,

        @NotBlank(message = "Nome do Curso é obrigatório")
        @Size(max = 100 , message = "No máximo 100 caracteres")
        String nomeCurso
) {
}
