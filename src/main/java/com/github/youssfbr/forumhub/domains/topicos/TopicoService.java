package com.github.youssfbr.forumhub.domains.topicos;

import com.github.youssfbr.forumhub.api.dtos.DadosCadastroTopico;
import com.github.youssfbr.forumhub.api.dtos.DadosDetalhamentoTopicoDTO;
import com.github.youssfbr.forumhub.domains.topicos.exceptions.MensagemException;
import com.github.youssfbr.forumhub.domains.topicos.exceptions.TituloException;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;


public class TopicoService implements ITopicoService {

    private final ITopicoRepository topicoRepository;

    public TopicoService(ITopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    @Override
    @Transactional
    public DadosDetalhamentoTopicoDTO salvarTopico(@Valid DadosCadastroTopico dados) {

        checarSeTituloExiste(dados.titulo());
        checarSeMensagemExiste(dados.mensagem());

        final Topico topicoCriado = topicoRepository.save(new Topico(dados));
        return new DadosDetalhamentoTopicoDTO(topicoCriado);
    }

    private void checarSeTituloExiste(String titulo) {
        if (titulo != null && topicoRepository.existsByTitulo(titulo)) {
            throw new TituloException("Título já existe");
        }
    }

    private void checarSeMensagemExiste(String mensagem) {
        if (mensagem != null && topicoRepository.existsByMensagem(mensagem)) {
            throw new MensagemException("Mensagem já existe");
        }
    }
}
