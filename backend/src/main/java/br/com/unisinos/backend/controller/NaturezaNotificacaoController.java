package br.com.unisinos.backend.controller;

import br.com.unisinos.backend.service.natureza.notificacao.CadastrarNaturezaNotificacaoService;
import br.com.unisinos.backend.service.natureza.notificacao.ListarNaturezasNotificacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.NaturezaNotificacaoApi;
import org.openapitools.model.NaturezaNotificacaoRequest;
import org.openapitools.model.NaturezaNotificacaoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NaturezaNotificacaoController implements NaturezaNotificacaoApi {

    private final CadastrarNaturezaNotificacaoService cadastrarNaturezaNotificacaoService;
    private final ListarNaturezasNotificacaoService listarNaturezasNotificacaoService;

    @Override
    public ResponseEntity<NaturezaNotificacaoResponse> cadastrarNaturezaNotificacao(@RequestBody @Valid NaturezaNotificacaoRequest request) {
        NaturezaNotificacaoResponse body = cadastrarNaturezaNotificacaoService.cadastrar(request);
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<NaturezaNotificacaoResponse>> listarNaturezasNotificacao() {
        return ResponseEntity.ok(listarNaturezasNotificacaoService.listar());
    }
}