package br.com.unisinos.backend.validator;

import br.com.unisinos.backend.domain.Recurso;
import br.com.unisinos.backend.exception.RegistroNaoEncontradoException;
import br.com.unisinos.backend.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RecursoServiceValidator {

    @Autowired
    private RecursoRepository repository;

    public Recurso encontrarRecurso(Integer idRecurso) throws RegistroNaoEncontradoException {
        Optional<Recurso> recurso = repository.findById(idRecurso);
        if (recurso.isEmpty()) {
            throw new RegistroNaoEncontradoException(idRecurso);
        }
        return recurso.get();
    }
}
