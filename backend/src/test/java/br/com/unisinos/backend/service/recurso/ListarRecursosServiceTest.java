package br.com.unisinos.backend.service.recurso;

import br.com.unisinos.backend.domain.Recurso;
import br.com.unisinos.backend.factory.RecursoFactory;
import br.com.unisinos.backend.mapper.RecursoMapper;
import br.com.unisinos.backend.repository.RecursoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.RecursoResponse;

import java.util.Arrays;
import java.util.List;

import static br.com.unisinos.backend.factory.RecursoFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListarRecursosServiceTest {

    @InjectMocks
    private ListarRecursosService teste;

    @Mock
    private RecursoMapper mapper;

    @Mock
    private RecursoRepository repository;

    @Test
    void testarListar() {
        when(repository.findAll()).thenReturn(mockRecursos());
        when(mapper.toResponse(any())).thenReturn(aguaResponse(), RecursoFactory.cobertorResponse());

        List<RecursoResponse> result = teste.listar();
        assertNotNull(result);
    }

    private List<Recurso> mockRecursos() {
        return Arrays.asList(agua(), cobertor());
    }
}