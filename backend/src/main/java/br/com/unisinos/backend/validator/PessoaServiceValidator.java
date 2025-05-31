package br.com.unisinos.backend.validator;

import br.com.unisinos.backend.domain.Pessoa;
import br.com.unisinos.backend.exception.RegistroNaoEncontradoException;
import br.com.unisinos.backend.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PessoaServiceValidator {

    private final PessoaRepository repository;

    public Pessoa encontrarPessoa(Integer idPessoa) {
        Optional<Pessoa> pessoaOptional = repository.findById(idPessoa);
        if (pessoaOptional.isEmpty()) {
            throw new RegistroNaoEncontradoException(idPessoa);
        }
        return pessoaOptional.get();
    }

}