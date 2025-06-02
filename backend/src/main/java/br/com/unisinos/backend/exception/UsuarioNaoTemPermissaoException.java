package br.com.unisinos.backend.exception;

import static org.springframework.http.HttpStatus.FORBIDDEN;

public class UsuarioNaoTemPermissaoException extends AbstractException {

    public static final String MENSAGEM = "O usuario não tem permissão para realizar a ação";

    public UsuarioNaoTemPermissaoException() {
        super(MENSAGEM, FORBIDDEN);
    }
}
