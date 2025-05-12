package br.com.unisinos.backend.service.usuario;

import br.com.unisinos.backend.domain.Cargo;
import br.com.unisinos.backend.mapper.CargoUsuarioMapper;
import br.com.unisinos.backend.repository.CargoRepository;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.CargoUsuarioRequest;
import org.openapitools.model.CargoUsuarioResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarCargoUsuarioService {

    private final CargoUsuarioMapper mapper;
    private final CargoRepository repository;

    public CargoUsuarioResponse cadastrar(CargoUsuarioRequest request) {
        Cargo cargo = mapper.toDomain(request);
        cargo = repository.save(cargo);
        return mapper.toResponse(cargo);
    }
}