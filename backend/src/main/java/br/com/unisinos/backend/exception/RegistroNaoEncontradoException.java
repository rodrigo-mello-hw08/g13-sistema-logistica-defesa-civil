package br.com.unisinos.backend.exception;

import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class RegistroNaoEncontradoException extends ResponseStatusException {
    public static final String MENSAGEM = "O registro de id %d, não pode ser encontrado";

    public RegistroNaoEncontradoException(Integer id) {
        super(NOT_FOUND, String.format(MENSAGEM, id));
    }
}