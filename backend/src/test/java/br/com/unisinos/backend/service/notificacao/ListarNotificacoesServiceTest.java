package br.com.unisinos.backend.service.notificacao;

import br.com.unisinos.backend.domain.Notificacao;
import br.com.unisinos.backend.factory.NotificacaoFactory;
import br.com.unisinos.backend.mapper.NotificacaoMapper;
import br.com.unisinos.backend.repository.NotificacaoRespository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.NotificacaoResponse;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListarNotificacoesServiceTest {

    @InjectMocks
    private ListarNotificacoesService listarNotificacoesService;

    @Mock
    private NotificacaoRespository respository;

    @Mock
    private NotificacaoMapper mapper;

    @Test
    void deveListarComSucesso() {
        when(respository.findAll()).thenReturn(mockNotificacoes());
        when(mapper.toResponse(any())).thenReturn(NotificacaoFactory.enchenteResponse());
        List<NotificacaoResponse> resultado = listarNotificacoesService.listar();
        assertNotNull(resultado);
    }

    private List<Notificacao> mockNotificacoes() {
        return List.of(NotificacaoFactory.enchente());
    }
}