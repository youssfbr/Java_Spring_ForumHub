package com.github.youssfbr.forumhub.domains.topicos;

import com.github.youssfbr.forumhub.api.dtos.DadosCadastroTopico;
import com.github.youssfbr.forumhub.api.dtos.DadosDetalhamentoTopicoDTO;
import org.springframework.transaction.annotation.Transactional;


public class TopicoService implements ITopicoService {

    private final ITopicoRepository topicoRepository;

    public TopicoService(ITopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    @Override
    @Transactional
    public DadosDetalhamentoTopicoDTO salvarTopico(DadosCadastroTopico dados) {
        final Topico topicoCriado = topicoRepository.save(new Topico(dados));
        return new DadosDetalhamentoTopicoDTO(topicoCriado);
    }
}
