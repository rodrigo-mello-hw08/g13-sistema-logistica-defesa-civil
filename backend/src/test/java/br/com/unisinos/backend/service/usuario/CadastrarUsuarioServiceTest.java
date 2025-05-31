package br.com.unisinos.backend.service.usuario;

import br.com.unisinos.backend.domain.Usuario;
import br.com.unisinos.backend.factory.CargoFactory;
import br.com.unisinos.backend.factory.UsuarioFactory;
import br.com.unisinos.backend.mapper.UsuarioMapper;
import br.com.unisinos.backend.repository.UsuarioRepository;
import br.com.unisinos.backend.validator.CargoServiceValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.UsuarioResponse;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CadastrarUsuarioServiceTest {

    @InjectMocks
    private CadastrarUsuarioService service;

    @Mock
    private UsuarioMapper mapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private CargoServiceValidator cargoServiceValidator;

    @Captor
    private ArgumentCaptor<Usuario> captor;

    @Test
    void deveCadastrarAPessoaComSucesso() {
        when(mapper.toDomain(any()))
            .thenReturn(UsuarioFactory.voluntario());
        when(passwordEncoder.encode(anyString()))
            .thenReturn("senha-criptografa");
        when(cargoServiceValidator.encontrarPorId(anyInt()))
            .thenReturn(CargoFactory.voluntario());
        when(mapper.toResponse(any()))
            .thenReturn(UsuarioFactory.voluntarioResponse());

        UsuarioResponse resultado = service.cadastrar(UsuarioFactory.voluntarioRequest());

        verify(usuarioRepository, times(1))
            .save(captor.capture());

        assertNotNull(resultado);
        assertNotNull(captor.getValue());
    }
}