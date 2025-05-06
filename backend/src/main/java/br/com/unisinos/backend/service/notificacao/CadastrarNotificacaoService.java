package br.com.unisinos.backend.service.notificacao;

import br.com.unisinos.backend.domain.NaturezaNotificacao;
import br.com.unisinos.backend.domain.Notificacao;
import br.com.unisinos.backend.exception.RegistroNaoEncontradoException;
import br.com.unisinos.backend.mapper.NotificacaoMapper;
import br.com.unisinos.backend.repository.NotificacaoRespository;
import br.com.unisinos.backend.validator.NaturezaNotificacaoServiceValidator;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.NotificacaoRequest;
import org.openapitools.model.NotificacaoResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarNotificacaoService {

    private final NotificacaoMapper mapper;
    private final NaturezaNotificacaoServiceValidator validator;
    private final NotificacaoRespository respository;

    public NotificacaoResponse cadastrar(NotificacaoRequest request) throws RegistroNaoEncontradoException {
        Notificacao notificacao = mapper.toDomain(request);
        NaturezaNotificacao naturezaNotificacao = validator.encontrarNaturezaNotificacao(request.getIdNaturezaNotificacao());
        notificacao.setNatureza(naturezaNotificacao);
        notificacao = respository.save(notificacao);
        return mapper.toResponse(notificacao);
    }
}
