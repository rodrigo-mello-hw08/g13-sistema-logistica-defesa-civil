package br.com.unisinos.backend.service.natureza.notificacao;

import br.com.unisinos.backend.domain.NaturezaNotificacao;
import br.com.unisinos.backend.mapper.NaturezaNotificacaoMapper;
import br.com.unisinos.backend.repository.NaturezaNotificacaoRepository;
import br.com.unisinos.backend.validator.UsuarioServiceValidator;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.NaturezaNotificacaoRequest;
import org.openapitools.model.NaturezaNotificacaoResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarNaturezaNotificacaoService {

    private final NaturezaNotificacaoMapper mapper;
    private final NaturezaNotificacaoRepository repository;
    private final UsuarioServiceValidator usuarioServiceValidator;

    public NaturezaNotificacaoResponse cadastrar(NaturezaNotificacaoRequest request) {
        usuarioServiceValidator.verificarPermissaoMembroDaDefesa();
        NaturezaNotificacao domain = mapper.toDomain(request);
        domain = repository.save(domain);
        return mapper.toResponse(domain);
    }
}
