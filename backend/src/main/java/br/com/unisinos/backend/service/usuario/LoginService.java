package br.com.unisinos.backend.service.usuario;

import br.com.unisinos.backend.domain.Usuario;
import br.com.unisinos.backend.exception.InformacoesIncorretasLoginException;
import br.com.unisinos.backend.exception.UsuarioNaoEncontradoException;
import br.com.unisinos.backend.validator.UsuarioServiceValidator;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.LoginRequest;
import org.openapitools.model.LoginResponse;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class LoginService {

    private static final long TEMPO_DE_EXPIRACAO = 10000L;
    private final UsuarioServiceValidator usuarioServiceValidator;
    private final JwtEncoder jwtEncoder;

    public LoginResponse logar(LoginRequest loginRequest) throws UsuarioNaoEncontradoException {
        Usuario usuario = usuarioServiceValidator.encontrarPorEmail(loginRequest.getEmail());

        if (informacoesDiferentes(loginRequest, usuario)) {
            throw new InformacoesIncorretasLoginException();
        }

        JwtClaimsSet jwt = getJwt(usuario);
        String token = jwtEncoder.encode(JwtEncoderParameters.from(jwt)).getTokenValue();

        return new LoginResponse(token, TEMPO_DE_EXPIRACAO);
    }

    private static boolean informacoesDiferentes(LoginRequest loginRequest, Usuario usuario) {
        return !usuario.getEmail().equals(loginRequest.getEmail())
                || !usuario.getSenha().equals(loginRequest.getSenha());
    }

    private JwtClaimsSet getJwt(Usuario usuario) {
        return JwtClaimsSet.builder()
            .issuer("seguranca-api")
            .subject(usuario.getNome())
            .expiresAt(Instant.now().plusSeconds(TEMPO_DE_EXPIRACAO))
            .issuedAt(Instant.now())
            .claim("email", usuario.getEmail())
            .claim("nome", usuario.getNome())
            .claim("id", usuario.getId())
            .build();
    }

}