package br.com.unisinos.backend.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AbstractException extends RuntimeException {
    private final String message;
    private final HttpStatus status;

    public AbstractException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }
}
