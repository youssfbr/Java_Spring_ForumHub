package com.github.youssfbr.forumhub.domains.topicos;

import com.github.youssfbr.forumhub.domains.respostas.Resposta;
import com.github.youssfbr.forumhub.domains.topicos.enums.TopicoStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "tb_topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100 , nullable = false)
    private String titulo;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String mensagem;

    @CreatedDate
    LocalDateTime dataCriacao;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;

    @Enumerated(EnumType.STRING)
    @Column(length = 20 , nullable = false)
    private TopicoStatus status;

    @Column(length = 100)
    private String autor;

    @Column(length = 100)
    private String curso;


    @OneToMany(mappedBy = "topico" , fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
    private List<Resposta> resposta;


}
