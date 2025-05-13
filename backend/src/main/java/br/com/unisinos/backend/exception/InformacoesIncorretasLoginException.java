package br.com.unisinos.backend.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class InformacoesIncorretasLoginException extends AbstractException {
    public static final String MENSAGEM = "As informações de login estão incorretas";

    public InformacoesIncorretasLoginException() {
        super(MENSAGEM, BAD_REQUEST);
    }
}
