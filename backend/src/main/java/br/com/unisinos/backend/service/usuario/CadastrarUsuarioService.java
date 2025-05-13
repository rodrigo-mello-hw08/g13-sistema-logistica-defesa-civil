package br.com.unisinos.backend.service.usuario;

import br.com.unisinos.backend.domain.Cargo;
import br.com.unisinos.backend.domain.Usuario;
import br.com.unisinos.backend.mapper.UsuarioMapper;
import br.com.unisinos.backend.repository.UsuarioRepository;
import br.com.unisinos.backend.validator.CargoServiceValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.CadastroUsuarioRequest;
import org.openapitools.model.UsuarioResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarUsuarioService {

    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;
    private final CargoServiceValidator cargoServiceValidator;

    @Transactional
    public UsuarioResponse cadastrar(CadastroUsuarioRequest request) {
        Usuario usuario = usuarioMapper.toDomain(request);
        String senhaCriptografada = passwordEncoder.encode(request.getSenha());
        usuario.setSenha(senhaCriptografada);

        Cargo cargo = cargoServiceValidator.encontrarPorId(request.getIdCargo());
        usuario.setCargo(cargo);

        usuario = usuarioRepository.save(usuario);
        UsuarioResponse response = usuarioMapper.toResponse(usuario);
        response.setCargo(cargo.getCargo());
        return response;
    }
}