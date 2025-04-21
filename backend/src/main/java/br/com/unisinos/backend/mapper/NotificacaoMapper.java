package br.com.unisinos.backend.mapper;

import br.com.unisinos.backend.domain.Notificacao;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.openapitools.model.NotificacaoRequest;
import org.openapitools.model.NotificacaoResponse;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificacaoMapper {

    private final ModelMapper mapper;
    private final NaturezaNotificacaoMapper naturezaMapper;

    public Notificacao toDomain(NotificacaoRequest request) {
        return mapper.map(request, Notificacao.class);
    }

    public NotificacaoResponse toResponse(Notificacao domain) {
        NotificacaoResponse response = mapper.map(domain, NotificacaoResponse.class);
        response.setNaturezaNotificacao(naturezaMapper.toResponse(domain.getNatureza()));
        return response;
    }

}