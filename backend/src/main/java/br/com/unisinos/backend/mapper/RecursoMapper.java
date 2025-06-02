package br.com.unisinos.backend.mapper;

import br.com.unisinos.backend.domain.Recurso;
import br.com.unisinos.backend.domain.RecursoAbrigo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.openapitools.model.RecursoDetalhadoResponse;
import org.openapitools.model.RecursoRequest;
import org.openapitools.model.RecursoResponse;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RecursoMapper {

    private final ModelMapper modelMapper;

    public Recurso toDomain(RecursoRequest request) {
        return modelMapper.map(request, Recurso.class);
    }

    public RecursoResponse toResponse(Recurso recurso) {
        return modelMapper.map(recurso, RecursoResponse.class);
    }

    public RecursoDetalhadoResponse toResponseRecursoDetalhe(RecursoAbrigo recursoAbrigo) {
        RecursoDetalhadoResponse recurso = modelMapper.map(recursoAbrigo, RecursoDetalhadoResponse.class);
        recurso.setId(recursoAbrigo.getRecurso().getId());
        recurso.setNome(recursoAbrigo.getRecurso().getNome());
        recurso.setUnidadeDeMedida(recursoAbrigo.getUnidadeMedida());
        return recurso;
    }
}