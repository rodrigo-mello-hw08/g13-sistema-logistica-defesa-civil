package br.com.unisinos.backend.mapper;

import br.com.unisinos.backend.controller.response.AbrigoResponse;
import br.com.unisinos.backend.domain.Abrigo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbrigoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public AbrigoResponse toResponse(Abrigo abrigo) {
        return modelMapper.map(abrigo, AbrigoResponse.class);
    }
}