package br.com.unisinos.backend.service.natureza.notificacao;

import br.com.unisinos.backend.domain.NaturezaNotificacao;
import br.com.unisinos.backend.mapper.NaturezaNotificacaoMapper;
import br.com.unisinos.backend.repository.NaturezaNotificacaoRepository;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.NaturezaNotificacaoRequest;
import org.openapitools.model.NaturezaNotificacaoResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarNaturezaNotificacaoService {

    private final NaturezaNotificacaoMapper mapper;
    private final NaturezaNotificacaoRepository repository;

    public NaturezaNotificacaoResponse cadastrar(NaturezaNotificacaoRequest request) {
        NaturezaNotificacao domain = mapper.toDomain(request);
        domain = repository.save(domain);
        return mapper.toResponse(domain);
    }
}
