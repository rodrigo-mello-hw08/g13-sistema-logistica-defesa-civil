package br.com.unisinos.backend.service.natureza.notificacao;

import br.com.unisinos.backend.domain.NaturezaNotificacao;
import br.com.unisinos.backend.mapper.NaturezaNotificacaoMapper;
import br.com.unisinos.backend.repository.NaturezaNotificacaoRepository;
import br.com.unisinos.backend.validator.UsuarioServiceValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.NaturezaNotificacaoRequest;
import org.openapitools.model.NaturezaNotificacaoResponse;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CadastrarNaturezaNotificacaoServiceTest {

    @InjectMocks
    private CadastrarNaturezaNotificacaoService service;

    @Mock
    private NaturezaNotificacaoMapper mapper;

    @Mock
    private NaturezaNotificacaoRepository repository;

    @Mock
    private UsuarioServiceValidator usuarioServiceValidator;

    @Captor
    private ArgumentCaptor<NaturezaNotificacao> captor;


    @Test
    void devePersistirNatureza() {
        NaturezaNotificacaoResponse response = mockResponse();

        doNothing().when(usuarioServiceValidator)
            .verificarPermissaoMembroDaDefesa();
        when(mapper.toDomain(any()))
            .thenReturn(mockNatureza());
        when(mapper.toResponse(any()))
            .thenReturn(response);

        NaturezaNotificacaoRequest request = new NaturezaNotificacaoRequest("Saúde");
        NaturezaNotificacaoResponse result = service.cadastrar(request);

        verify(repository, times(1))
            .save(captor.capture());

        assertNotNull(result);
        assertNotNull(captor.getValue());
    }

    private static NaturezaNotificacao mockNatureza() {
        return NaturezaNotificacao.builder()
            .natureza("Saúde")
            .build();
    }

    private static NaturezaNotificacaoResponse mockResponse() {
        return new NaturezaNotificacaoResponse()
            .id(1)
            .natureza("Saúde");
    }
}