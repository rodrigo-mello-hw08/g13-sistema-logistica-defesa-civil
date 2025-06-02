package br.com.unisinos.backend.service.abrigo.pessoa;

import br.com.unisinos.backend.mapper.PessoaMapper;
import br.com.unisinos.backend.repository.PessoaAbrigoRepository;
import br.com.unisinos.backend.validator.PessoaServiceValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

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
    void deveEncontrarPessoa() {

    }

}