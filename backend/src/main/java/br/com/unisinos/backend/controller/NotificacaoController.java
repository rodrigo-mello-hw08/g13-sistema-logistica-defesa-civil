package br.com.unisinos.backend.controller;

import br.com.unisinos.backend.service.notificacao.CadastrarNotificacaoService;
import br.com.unisinos.backend.service.notificacao.ListarNotificacoesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.api.NotificacaoApi;
import org.openapitools.model.NotificacaoRequest;
import org.openapitools.model.NotificacaoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class NotificacaoController implements NotificacaoApi {

    private final CadastrarNotificacaoService cadastrarNotificacaoService;
    private final ListarNotificacoesService listarNotificacoesService;

    @Override
    public ResponseEntity<NotificacaoResponse> cadastrarNotificacao(@RequestBody @Valid NotificacaoRequest notificacaoRequest) {
        try {
            NotificacaoResponse body = cadastrarNotificacaoService.cadastrar(notificacaoRequest);
            return new ResponseEntity<>(body, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<NotificacaoResponse>> listarNotificacoes() {
        return ResponseEntity.ok(listarNotificacoesService.listar());
    }
}