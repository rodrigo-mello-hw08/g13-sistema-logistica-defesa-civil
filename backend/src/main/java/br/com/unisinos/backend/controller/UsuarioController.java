package br.com.unisinos.backend.controller;

import br.com.unisinos.backend.service.usuario.CadastrarCargoUsuarioService;
import br.com.unisinos.backend.service.usuario.CadastrarUsuarioService;
import br.com.unisinos.backend.service.usuario.ListarCargosUsuarioService;
import br.com.unisinos.backend.service.usuario.LoginService;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.UsuarioApi;
import org.openapitools.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsuarioController implements UsuarioApi {

    private final LoginService loginService;
    private final CadastrarUsuarioService cadastrarUsuarioService;
    private final ListarCargosUsuarioService listarCargosUsuarioService;
    private final CadastrarCargoUsuarioService cadastrarCargoUsuarioService;

    @Override
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUsuario(LoginRequest loginRequest) {
        return ResponseEntity.ok(loginService.logar(loginRequest));
    }

    @Override
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(CadastroUsuarioRequest cadastroUsuarioRequest) {
        UsuarioResponse body = cadastrarUsuarioService.cadastrar(cadastroUsuarioRequest);
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CargoUsuarioResponse>> listarCargosUsuario() {
        return ResponseEntity.ok(listarCargosUsuarioService.listar());
    }

    @Override
    public ResponseEntity<CargoUsuarioResponse> cadastrarCargoUsuario(CargoUsuarioRequest cargoUsuarioRequest) {
        CargoUsuarioResponse body = cadastrarCargoUsuarioService.cadastrar(cargoUsuarioRequest);
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }
}