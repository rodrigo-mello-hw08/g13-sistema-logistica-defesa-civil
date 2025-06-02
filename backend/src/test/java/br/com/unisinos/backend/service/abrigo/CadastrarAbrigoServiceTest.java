package br.com.unisinos.backend.service.abrigo;

import br.com.unisinos.backend.domain.Abrigo;
import br.com.unisinos.backend.factory.AbrigoFactory;
import br.com.unisinos.backend.mapper.AbrigoMapper;
import br.com.unisinos.backend.repository.AbrigoRepository;
import br.com.unisinos.backend.validator.UsuarioServiceValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.AbrigoResponse;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CadastrarAbrigoServiceTest {

    @InjectMocks
    private CadastrarAbrigoService service;

    @Mock
    private AbrigoMapper abrigoMapper;

    @Mock
    private AbrigoRepository repository;

    @Mock
    private UsuarioServiceValidator usuarioServiceValidator;

    @Captor
    private ArgumentCaptor<Abrigo> captor;

    @Test
    void deveCadastrarAbrigoComSucesso() {
        doNothing().when(usuarioServiceValidator)
            .verificarPermissaoMembroDaDefesa();

        when(abrigoMapper.toDomain(any()))
            .thenReturn(AbrigoFactory.ginasio());

        when(abrigoMapper.toResponse(any()))
            .thenReturn(AbrigoFactory.ginasioResponse());

        AbrigoResponse resultado = service.cadastrar(AbrigoFactory.ginasioRequest());

        verify(repository, times(1))
            .save(captor.capture());

        assertNotNull(resultado);
        assertNotNull(captor.getValue());
    }
}