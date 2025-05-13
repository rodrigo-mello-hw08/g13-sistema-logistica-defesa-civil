package br.com.unisinos.backend.validator;

import br.com.unisinos.backend.domain.Abrigo;
import br.com.unisinos.backend.exception.RegistroNaoEncontradoException;
import br.com.unisinos.backend.exception.UsuarioNaoTemPermissaoException;
import br.com.unisinos.backend.repository.AbrigoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AbrigoServiceValidator {

    private final AbrigoRepository abrigoRepository;

    public Abrigo encontrarAbrigo(Integer idAbrigo) {
        Optional<Abrigo> abrigoOptional = abrigoRepository.findById(idAbrigo);
        if (abrigoOptional.isEmpty()) {
            throw new RegistroNaoEncontradoException(idAbrigo);
        }
        return abrigoOptional.get();
    }
}