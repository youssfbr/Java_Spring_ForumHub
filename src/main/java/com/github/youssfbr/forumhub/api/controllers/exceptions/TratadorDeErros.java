package com.github.youssfbr.forumhub.api.controllers.exceptions;

import com.github.youssfbr.forumhub.domains.topicos.exceptions.MensagemException;
import com.github.youssfbr.forumhub.domains.topicos.exceptions.TituloException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(TituloException.class)
    public ResponseEntity handleTituloException(TituloException ex) {

        final List<FieldError> errors = new ArrayList<>();
        errors.add(new FieldError("Erro", "titulo", ex.getMessage()));

        return ResponseEntity.badRequest().body(errors.stream().map(DadosErroValidacao::new));
    }

    @ExceptionHandler(MensagemException.class)
    public ResponseEntity handleMensagemException(MensagemException ex) {

        final List<FieldError> errors = new ArrayList<>();
        errors.add(new FieldError("Erro", "mensagem", ex.getMessage()));

        return ResponseEntity.badRequest().body(errors.stream().map(DadosErroValidacao::new));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosErroValidacao>> tratarErro400(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest()
                .body(ex.getFieldErrors()
                        .stream()
                        .map(DadosErroValidacao::new)
                        .toList());
    }

    private record DadosErroValidacao(String campo , String mensagem) {
        public DadosErroValidacao(FieldError erro) {
            this(erro.getField() , erro.getDefaultMessage());
        }
    }

}
