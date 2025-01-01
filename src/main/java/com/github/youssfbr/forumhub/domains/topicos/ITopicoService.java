package com.github.youssfbr.forumhub.domains.topicos;

import com.github.youssfbr.forumhub.api.dtos.DadosCadastroTopico;
import com.github.youssfbr.forumhub.api.dtos.DadosDetalhamentoTopicoDTO;

public interface ITopicoService {
    DadosDetalhamentoTopicoDTO salvarTopico(DadosCadastroTopico dados);
}
