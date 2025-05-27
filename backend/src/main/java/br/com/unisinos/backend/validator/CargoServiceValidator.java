package br.com.unisinos.backend.validator;

import br.com.unisinos.backend.domain.Cargo;
import br.com.unisinos.backend.domain.Usuario;
import br.com.unisinos.backend.exception.RegistroNaoEncontradoException;
import br.com.unisinos.backend.exception.UsuarioNaoEncontradoException;
import br.com.unisinos.backend.repository.CargoRepository;
import br.com.unisinos.backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CargoServiceValidator {

    private final CargoRepository repository;

    public Cargo encontrarPorId(Integer id) throws UsuarioNaoEncontradoException {
        Optional<Cargo> cargo = repository.findById(id);
        if (cargo.isEmpty()) {
            throw new RegistroNaoEncontradoException(id);
        }
        return cargo.get();
    }
}