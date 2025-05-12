package br.com.unisinos.backend.mapper;

import br.com.unisinos.backend.domain.Cargo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.openapitools.model.CargoUsuarioRequest;
import org.openapitools.model.CargoUsuarioResponse;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CargoUsuarioMapper {

    private final ModelMapper modelMapper;

    public Cargo toDomain(CargoUsuarioRequest request) {
        return modelMapper.map(request, Cargo.class);
    }

    public CargoUsuarioResponse toResponse(Cargo domain) {
        return modelMapper.map(domain, CargoUsuarioResponse.class);
    }
}