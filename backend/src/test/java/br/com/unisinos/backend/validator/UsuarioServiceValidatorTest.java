package br.com.unisinos.backend.validator;

import br.com.unisinos.backend.domain.Usuario;
import br.com.unisinos.backend.exception.UsuarioNaoEncontradoException;
import br.com.unisinos.backend.exception.UsuarioNaoTemPermissaoException;
import br.com.unisinos.backend.factory.UsuarioFactory;
import br.com.unisinos.backend.repository.UsuarioRepository;
import br.com.unisinos.backend.service.usuario.UsuarioAutenticadoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceValidatorTest {

    @InjectMocks
    private UsuarioServiceValidator service;

    @Mock
    private UsuarioRepository repository;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Test
    void deveLancarUsuarioNaoEncontradoException() {
        when(repository.findByEmail(any())).thenReturn(Optional.empty());
        assertThrows(UsuarioNaoEncontradoException.class,
            () -> service.encontrarPorEmail("emailInvalido"));
    }

    @Test
    void deveRetornarUsuario() {
        Usuario usuario = UsuarioFactory.membroDaDefesa();
        when(repository.findByEmail(any())).thenReturn(Optional.of(usuario));
        Usuario resultado = service.encontrarPorEmail("alisson@gmail.com.br");
        assertNotNull(resultado);
    }

    @Test
    void deveLancarUsuarioNaoTemPermissaoException() {
        Usuario usuario = UsuarioFactory.voluntario();
        when(usuarioAutenticadoService.getById()).thenReturn(usuario);
        assertThrows(UsuarioNaoTemPermissaoException.class,
            () -> service.verificarPermissaoMembroDaDefesa());
    }

    @Test
    void naoDeveLancarExcecaoQuandoUsuarioTemPermissao() {
        Usuario usuario = UsuarioFactory.membroDaDefesa();
        when(usuarioAutenticadoService.getById()).thenReturn(usuario);
        assertDoesNotThrow(() -> service.verificarPermissaoMembroDaDefesa());
    }
}