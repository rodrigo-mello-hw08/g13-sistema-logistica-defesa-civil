package br.com.unisinos.backend.service.abrigo.pessoa;

import br.com.unisinos.backend.domain.Abrigo;
import br.com.unisinos.backend.exception.RegistroNaoEncontradoException;
import br.com.unisinos.backend.factory.AbrigoFactory;
import br.com.unisinos.backend.factory.PessoaFactory;
import br.com.unisinos.backend.mapper.PessoaMapper;
import br.com.unisinos.backend.repository.PessoaAbrigoRepository;
import br.com.unisinos.backend.validator.PessoaServiceValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.PessoaDetalhadaResponse;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EncontrarPessoaPorIdServiceTest {

    @InjectMocks
    private EncontrarPessoaPorIdService service;

    @Mock
    private PessoaServiceValidator pessoaServiceValidator;

    @Mock
    private PessoaAbrigoRepository pessoaAbrigoRepository;

    @Mock
    private PessoaMapper pessoaMapper;

    @Test
    void deveDarErroAoBuscarPessoa() {
        doThrow(new RegistroNaoEncontradoException(20))
            .when(pessoaServiceValidator).encontrarPessoa(anyInt());

        assertThrows(RegistroNaoEncontradoException.class, () ->
            service.encontrarPessoa(1));
    }

    @Test
    void deveEncontrarPessoa() {
        when(pessoaServiceValidator.encontrarPessoa(anyInt()))
            .thenReturn(PessoaFactory.augusto());
        when(pessoaAbrigoRepository.encontrarAbrigosPessoa(anyInt()))
            .thenReturn(mockListaAbrigos());
        when(pessoaMapper.toPessoaDetalhada(any()))
            .thenReturn(PessoaFactory.augustoDetalhado());

        PessoaDetalhadaResponse resultado = service.encontrarPessoa(20);
        assertNotNull(resultado);
    }

    private List<Abrigo> mockListaAbrigos() {
        return List.of(AbrigoFactory.ginasio());
    }

}