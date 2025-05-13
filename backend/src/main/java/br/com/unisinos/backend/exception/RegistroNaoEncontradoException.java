package br.com.unisinos.backend.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class RegistroNaoEncontradoException extends AbstractException {
    public static final String MENSAGEM = "O registro de id %d, não pode ser encontrado";

    public RegistroNaoEncontradoException(Integer id) {
        super(String.format(MENSAGEM, id), NOT_FOUND);
    }
}