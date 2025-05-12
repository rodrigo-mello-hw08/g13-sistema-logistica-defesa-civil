package br.com.unisinos.backend.mapper;

import br.com.unisinos.backend.domain.NaturezaNotificacao;
import org.modelmapper.ModelMapper;
import org.openapitools.model.NaturezaNotificacaoRequest;
import org.openapitools.model.NaturezaNotificacaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NaturezaNotificacaoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public NaturezaNotificacao toDomain(NaturezaNotificacaoRequest request) {
        return modelMapper.map(request, NaturezaNotificacao.class);
    }

    public NaturezaNotificacaoResponse toResponse(NaturezaNotificacao domain) {
        return modelMapper.map(domain, NaturezaNotificacaoResponse.class);
    }
}
