package com.github.youssfbr.forumhub.config;

import com.github.youssfbr.forumhub.domains.topicos.ITopicoRepository;
import com.github.youssfbr.forumhub.domains.topicos.TopicoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicoConfig {

    @Bean
    TopicoService topicoService(ITopicoRepository topicoRepository) {
        return new TopicoService(topicoRepository);
    }
}
