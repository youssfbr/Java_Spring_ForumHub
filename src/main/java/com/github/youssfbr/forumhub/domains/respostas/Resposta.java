package com.github.youssfbr.forumhub.domains.respostas;

import com.github.youssfbr.forumhub.domains.topicos.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "tb_respostas")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String mensagem;

    @CreatedDate
    LocalDateTime dataCriacao;

    private String autor;

    private String solucao;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;
}
