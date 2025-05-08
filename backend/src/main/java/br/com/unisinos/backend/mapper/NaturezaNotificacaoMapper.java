package br.com.unisinos.backend.mapper;

import br.com.unisinos.backend.domain.NaturezaNotificacao;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.openapitools.model.NaturezaNotificacaoRequest;
import org.openapitools.model.NaturezaNotificacaoResponse;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NaturezaNotificacaoMapper {

    private final ModelMapper modelMapper;

    public NaturezaNotificacao toDomain(NaturezaNotificacaoRequest request) {
        return modelMapper.map(request, NaturezaNotificacao.class);
    }

    public NaturezaNotificacaoResponse toResponse(NaturezaNotificacao domain) {
        return modelMapper.map(domain, NaturezaNotificacaoResponse.class);
    }
}
