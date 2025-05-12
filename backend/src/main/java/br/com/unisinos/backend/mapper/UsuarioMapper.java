package br.com.unisinos.backend.mapper;

import br.com.unisinos.backend.domain.Usuario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.openapitools.model.CadastroUsuarioRequest;
import org.openapitools.model.UsuarioResponse;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioMapper {

    private final ModelMapper modelMapper;

    public Usuario toDomain(CadastroUsuarioRequest request) {
        return modelMapper.map(request, Usuario.class);
    }

    public UsuarioResponse toResponse(Usuario domain) {
        return modelMapper.map(domain, UsuarioResponse.class);
    }
}
