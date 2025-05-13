package br.com.unisinos.backend.interceptor;

import br.com.unisinos.backend.exception.InformacoesIncorretasLoginException;
import br.com.unisinos.backend.exception.RegistroNaoEncontradoException;
import br.com.unisinos.backend.exception.UsuarioNaoEncontradoException;
import br.com.unisinos.backend.exception.UsuarioNaoTemPermissaoException;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.model.Erro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorControllerInterceptor {



    @ExceptionHandler(InformacoesIncorretasLoginException.class)
    public ResponseEntity<Erro> handleException(InformacoesIncorretasLoginException exception) {
        log.error(exception.getMessage(), exception);
        return buildResponse(exception.getMessage(), exception.getStatus());
    }

    @ExceptionHandler(RegistroNaoEncontradoException.class)
    public ResponseEntity<Erro> handleException(RegistroNaoEncontradoException exception) {
        log.error(exception.getMessage(), exception);
        return buildResponse(exception.getMessage(), exception.getStatus());
    }

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<Erro> handleException(UsuarioNaoEncontradoException exception) {
        log.error(exception.getMessage(), exception);
        return buildResponse(exception.getMessage(), exception.getStatus());
    }

    @ExceptionHandler(UsuarioNaoTemPermissaoException.class)
    public ResponseEntity<Erro> handleException(UsuarioNaoTemPermissaoException exception) {
        log.error(exception.getMessage(), exception);
        return buildResponse(exception.getMessage(), exception.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Erro> handleException(Exception exception) {
        log.error("Ocorreu um erro inesperado: " + exception.getMessage(), exception);
        return buildResponse("Ocorreu um erro inesperado na aplicação", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Erro> buildResponse(String menssage, HttpStatus httpStatus) {
        Erro errorResponse = new Erro(String.valueOf(httpStatus.value()), menssage);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
