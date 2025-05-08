package br.com.unisinos.backend.controller;

import br.com.unisinos.backend.service.usuario.CadastrarUsuarioService;
import br.com.unisinos.backend.service.usuario.LoginService;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.UsuarioApi;
import org.openapitools.model.CadastroUsuarioRequest;
import org.openapitools.model.LoginRequest;
import org.openapitools.model.LoginResponse;
import org.openapitools.model.UsuarioResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsuarioController implements UsuarioApi {

    private final LoginService loginService;
    private final CadastrarUsuarioService cadastrarUsuarioService;

    @Override
    public ResponseEntity<LoginResponse> loginUsuario(LoginRequest loginRequest) {
        return ResponseEntity.ok(loginService.logar(loginRequest));
    }

    @Override
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(CadastroUsuarioRequest cadastroUsuarioRequest) {
        UsuarioResponse body = cadastrarUsuarioService.cadastrar(cadastroUsuarioRequest);
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }
}