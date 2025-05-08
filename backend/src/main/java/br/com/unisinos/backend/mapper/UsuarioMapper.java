package br.com.unisinos.backend.mapper;

import br.com.unisinos.backend.domain.Usuario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.openapitools.model.CadastroUsuarioRequest;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioMapper {

    private final ModelMapper modelMapper;

    public Usuario toEntity(CadastroUsuarioRequest request) {
        return modelMapper.map(request, Usuario.class);
    }
}
