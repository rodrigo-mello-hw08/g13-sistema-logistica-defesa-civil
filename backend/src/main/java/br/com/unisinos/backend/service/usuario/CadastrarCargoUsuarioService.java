package br.com.unisinos.backend.service.usuario;

import br.com.unisinos.backend.domain.Cargo;
import br.com.unisinos.backend.mapper.CargoUsuarioMapper;
import br.com.unisinos.backend.repository.CargoRepository;
import br.com.unisinos.backend.validator.UsuarioServiceValidator;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.CargoUsuarioRequest;
import org.openapitools.model.CargoUsuarioResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarCargoUsuarioService {

    private final CargoUsuarioMapper mapper;
    private final CargoRepository repository;
    private final UsuarioServiceValidator usuarioServiceValidator;

    public CargoUsuarioResponse cadastrar(CargoUsuarioRequest request) {
        usuarioServiceValidator.verificarPermissaoMembroDaDefesa();
        Cargo cargo = mapper.toDomain(request);
        cargo = repository.save(cargo);
        return mapper.toResponse(cargo);
    }
}