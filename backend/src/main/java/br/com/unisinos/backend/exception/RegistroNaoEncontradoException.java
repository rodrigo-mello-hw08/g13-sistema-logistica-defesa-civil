package br.com.unisinos.backend.exception;

public class RegistroNaoEncontradoException extends Exception {
    public static final String MENSAGEM = "O registro de id %d, não pode ser encontrado";

    public RegistroNaoEncontradoException(Integer id) {
        super(String.format(MENSAGEM, id));
    }
}
