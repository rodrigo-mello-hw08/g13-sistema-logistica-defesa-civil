package br.com.unisinos.backend.validator;

import br.com.unisinos.backend.domain.NaturezaNotificacao;
import br.com.unisinos.backend.exception.RegistroNaoEncontradoException;
import br.com.unisinos.backend.repository.NaturezaNotificacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NaturezaNotificacaoServiceValidator {

    private final NaturezaNotificacaoRepository repository;

    public NaturezaNotificacao encontrarNaturezaNotificacao(Integer id) throws RegistroNaoEncontradoException {
        Optional<NaturezaNotificacao> naturezaNotificacao = repository.findById(id);
        if (naturezaNotificacao.isEmpty()) {
            throw new RegistroNaoEncontradoException(id);
        }
        return naturezaNotificacao.get();
    }
}
