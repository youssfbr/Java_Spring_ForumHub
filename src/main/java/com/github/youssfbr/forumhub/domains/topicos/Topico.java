package com.github.youssfbr.forumhub.domains.topicos;

import com.github.youssfbr.forumhub.api.dtos.DadosCadastroTopico;
import com.github.youssfbr.forumhub.domains.respostas.Resposta;
import com.github.youssfbr.forumhub.domains.topicos.enums.TopicoStatus;
import jakarta.persistence.*;


import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100 , nullable = false)
    private String titulo;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String mensagem;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dataCriacao;

    @Enumerated(EnumType.STRING)
    @Column(length = 20 , nullable = false)
    private TopicoStatus status;

    @Column(length = 100)
    private String autor;

    @Column(length = 100)
    private String curso;

    @OneToMany(mappedBy = "topico" , fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
    private List<Resposta> resposta;

    public Topico() {}

    public Topico(String titulo , String mensagem , String autor , String curso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.autor = autor;
        this.curso = curso;
    }

    public Topico(DadosCadastroTopico dados) {
        titulo = dados.titulo();
        mensagem = dados.mensagem();
        autor = dados.nomeAutor();
        curso = dados.nomeCurso();
    }

    @PrePersist
    public void onPrePersist() {
        status = TopicoStatus.NAO_RESPONDIDO;
        dataCriacao = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Instant dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public TopicoStatus getStatus() {
        return status;
    }

    public void setStatus(TopicoStatus status) {
        this.status = status;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<Resposta> getResposta() {
        return resposta;
    }

    public void setResposta(List<Resposta> resposta) {
        this.resposta = resposta;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Topico topico = (Topico) o;
        return Objects.equals(id , topico.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
