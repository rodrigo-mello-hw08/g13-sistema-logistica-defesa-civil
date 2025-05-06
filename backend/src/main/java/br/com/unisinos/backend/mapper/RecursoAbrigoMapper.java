package br.com.unisinos.backend.mapper;

import br.com.unisinos.backend.domain.RecursoAbrigo;
import org.modelmapper.ModelMapper;
import org.openapitools.model.AbrigoRecursoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecursoAbrigoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public RecursoAbrigo toDomain(AbrigoRecursoRequest request) {
        return modelMapper.map(request, RecursoAbrigo.class);
    }
}
