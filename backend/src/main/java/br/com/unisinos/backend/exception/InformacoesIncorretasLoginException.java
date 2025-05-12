package br.com.unisinos.backend.exception;

import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class InformacoesIncorretasLoginException extends ResponseStatusException {
    public static final String MENSAGEM = "As informações de login estão incorretas";

    public InformacoesIncorretasLoginException() {
        super(BAD_REQUEST, MENSAGEM);
    }
}
