package com.github.youssfbr.forumhub.domains.topicos;

import com.github.youssfbr.forumhub.domains.topicos.dtos.DadosAtualizacaoTopico;
import com.github.youssfbr.forumhub.domains.topicos.dtos.DadosCadastroTopico;
import com.github.youssfbr.forumhub.domains.topicos.dtos.DadosDetalhamentoTopicoDTO;
import com.github.youssfbr.forumhub.domains.topicos.dtos.DadosListagemTopico;
import com.github.youssfbr.forumhub.domains.topicos.exceptions.MensagemException;
import com.github.youssfbr.forumhub.domains.topicos.exceptions.TituloException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;


public class TopicoService implements ITopicoService {

    private final ITopicoRepository topicoRepository;

    public TopicoService(ITopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DadosListagemTopico> paginar(Pageable paginacao) {
        return topicoRepository.findAll(paginacao).map(DadosListagemTopico::new);
    }

    @Override
    @Transactional(readOnly = true)
    public DadosDetalhamentoTopicoDTO detalhar(@NotNull @Positive Long id) {
        final Topico topico = topicoRepository.getReferenceById(id);
        return new DadosDetalhamentoTopicoDTO(topico);
    }

    @Override
    @Transactional
    public DadosDetalhamentoTopicoDTO salvarTopico(@Valid DadosCadastroTopico dados) {

        checarSeTituloExiste(dados.titulo());
        checarSeMensagemExiste(dados.mensagem());

        final Topico topicoCriado = topicoRepository.save(new Topico(dados));
        return new DadosDetalhamentoTopicoDTO(topicoCriado);
    }

    @Override
    @Transactional
    public DadosDetalhamentoTopicoDTO atualizar(@NotNull @Positive Long id , @Valid DadosAtualizacaoTopico dados) {
        final Topico topico = topicoRepository.getReferenceById(id);
        topico.atualizarInformacoes(dados);
        return new DadosDetalhamentoTopicoDTO(topico);
    }

    @Override
    @Transactional
    public void deletar(@NotNull @Positive Long id) {
        topicoRepository.deleteById(id);
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
