package com.github.youssfbr.forumhub.config;

import com.github.youssfbr.forumhub.domains.topicos.ITopicoRepository;
import com.github.youssfbr.forumhub.domains.topicos.TopicoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class TopicoConfig {

    @Bean
    TopicoService topicoService(ITopicoRepository topicoRepository) {
        return new TopicoService(topicoRepository);
    }
}
