package br.com.unisinos.backend.mapper;

import br.com.unisinos.backend.domain.Abrigo;
import org.modelmapper.ModelMapper;
import org.openapitools.model.AbrigoRequest;
import org.openapitools.model.AbrigoResponse;
import org.openapitools.model.DetalhesAbrigoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbrigoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Abrigo toDomain(AbrigoRequest abrigo) {
        return modelMapper.map(abrigo, Abrigo.class);
    }

    public AbrigoResponse toResponse(Abrigo abrigo) {
        return modelMapper.map(abrigo, AbrigoResponse.class);
    }

    public DetalhesAbrigoResponse toDetalheAbrigo(Abrigo abrigo) {
        return modelMapper.map(abrigo, DetalhesAbrigoResponse.class);
    }
}