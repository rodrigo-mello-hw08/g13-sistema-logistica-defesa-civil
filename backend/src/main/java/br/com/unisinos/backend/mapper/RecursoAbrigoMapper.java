package br.com.unisinos.backend.mapper;

import br.com.unisinos.backend.domain.RecursoAbrigo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.openapitools.model.AbrigoRecursoRequest;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RecursoAbrigoMapper {

    private final ModelMapper modelMapper;

    public RecursoAbrigo toDomain(AbrigoRecursoRequest request) {
        return modelMapper.map(request, RecursoAbrigo.class);
    }
}
