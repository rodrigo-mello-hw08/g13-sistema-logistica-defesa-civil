package br.com.unisinos.backend.service.usuario;

import br.com.unisinos.backend.mapper.CargoUsuarioMapper;
import br.com.unisinos.backend.repository.CargoRepository;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.CargoUsuarioResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarCargosUsuarioService {

    private final CargoRepository repository;
    private final CargoUsuarioMapper mapper;

    public List<CargoUsuarioResponse> listar() {
        return repository.findAll().stream()
            .map(mapper::toResponse)
            .toList();
    }
}
