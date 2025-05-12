package br.com.unisinos.backend.validator;

import br.com.unisinos.backend.domain.Usuario;
import br.com.unisinos.backend.exception.UsuarioNaoEncontradoException;
import br.com.unisinos.backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioServiceValidator {

    private final UsuarioRepository repository;

    public Usuario encontrarPorEmail(String email) throws UsuarioNaoEncontradoException {
        Optional<Usuario> usuario = repository.findByEmail(email);
        if (usuario.isEmpty()) {
            throw new UsuarioNaoEncontradoException(email);
        }
        return usuario.get();
    }
}