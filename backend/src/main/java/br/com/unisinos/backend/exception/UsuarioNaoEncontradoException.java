package br.com.unisinos.backend.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class UsuarioNaoEncontradoException extends AbstractException {
    public static final String MENSAGEM = "O usuario com email %s, não pode ser encontrado";

    public UsuarioNaoEncontradoException(String email) {
        super(String.format(MENSAGEM, email), NOT_FOUND);
    }
}
