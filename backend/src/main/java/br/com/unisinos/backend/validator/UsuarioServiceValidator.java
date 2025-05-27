package br.com.unisinos.backend.validator;

import br.com.unisinos.backend.domain.Usuario;
import br.com.unisinos.backend.exception.UsuarioNaoEncontradoException;
import br.com.unisinos.backend.exception.UsuarioNaoTemPermissaoException;
import br.com.unisinos.backend.repository.UsuarioRepository;
import br.com.unisinos.backend.service.usuario.UsuarioAutenticadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioServiceValidator {

    public static final String MEMBRO_DA_DEFESA = "Membro da Defesa";
    private final UsuarioRepository repository;
    private final UsuarioAutenticadoService usuarioAutenticadoService;

    public Usuario encontrarPorEmail(String email) throws UsuarioNaoEncontradoException {
        Optional<Usuario> usuario = repository.findByEmail(email);
        if (usuario.isEmpty()) {
            throw new UsuarioNaoEncontradoException(email);
        }
        return usuario.get();
    }

    public void verificarPermissaoMembroDaDefesa() {
        Usuario usuario = usuarioAutenticadoService.getById();
        if (!MEMBRO_DA_DEFESA.equals(usuario.getCargo().getCargo())) {
            throw new UsuarioNaoTemPermissaoException();
        }
    }
}