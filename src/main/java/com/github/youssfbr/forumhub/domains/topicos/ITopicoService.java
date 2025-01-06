package com.github.youssfbr.forumhub.domains.topicos;

import com.github.youssfbr.forumhub.domains.topicos.dtos.DadosCadastroTopico;
import com.github.youssfbr.forumhub.domains.topicos.dtos.DadosDetalhamentoTopicoDTO;
import com.github.youssfbr.forumhub.domains.topicos.dtos.DadosListagemTopico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITopicoService {

    Page<DadosListagemTopico> paginar(Pageable paginacao);
    DadosDetalhamentoTopicoDTO detalhar(Long id);
    DadosDetalhamentoTopicoDTO salvarTopico(DadosCadastroTopico dados);

}
