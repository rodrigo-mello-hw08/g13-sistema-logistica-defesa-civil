package br.com.unisinos.backend.exception;

import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class UsuarioNaoEncontradoException extends ResponseStatusException {
    public static final String MENSAGEM = "O usuario com email %s, não pode ser encontrado";

    public UsuarioNaoEncontradoException(String email) {
        super(NOT_FOUND, String.format(MENSAGEM, email));
    }
}
