package com.github.youssfbr.forumhub.domains.topicos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITopicoRepository extends JpaRepository<Topico , Long> {

    boolean existsByTitulo(String titulo);
    boolean existsByMensagem(String mensagem);
}
