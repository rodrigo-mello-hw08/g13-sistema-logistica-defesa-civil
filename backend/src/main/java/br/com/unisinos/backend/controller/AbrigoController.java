package br.com.unisinos.backend.controller;

import br.com.unisinos.backend.service.abrigo.CadastrarRecursoAbrigoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.api.AbrigoApi;
import br.com.unisinos.backend.service.abrigo.CadastrarAbrigoService;
import br.com.unisinos.backend.service.abrigo.ListarAbrigosService;
import br.com.unisinos.backend.service.abrigo.DetalharAbrigoService;
import org.openapitools.model.AbrigoRecursoRequest;
import org.openapitools.model.AbrigoRequest;
import org.openapitools.model.AbrigoResponse;
import org.openapitools.model.DetalhesAbrigoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AbrigoController implements AbrigoApi {

    private final ListarAbrigosService listarAbrigosService;
    private final CadastrarAbrigoService cadastrarAbrigoService;
    private final CadastrarRecursoAbrigoService cadastrarRecursoAbrigoService;
    private final DetalharAbrigoService detalharAbrigoService;

    @Override
    public ResponseEntity<List<AbrigoResponse>> listarAbrigos() {
        return ResponseEntity.ok(listarAbrigosService.listarAbrigos());
    }

    @Override
    public ResponseEntity<AbrigoResponse> cadastrarAbrigo(@RequestBody @Valid AbrigoRequest request) {
        AbrigoResponse body = cadastrarAbrigoService.cadastrar(request);
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> cadastrarRecursoAbrigo(@PathVariable Integer idAbrigo, @RequestBody AbrigoRecursoRequest abrigoRecursoRequest) {
        try {
            cadastrarRecursoAbrigoService.cadastrar(idAbrigo, abrigoRecursoRequest);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<DetalhesAbrigoResponse> detalharAbrigo(Integer idAbrigo) {
        try {
            DetalhesAbrigoResponse body = detalharAbrigoService.detalhar(idAbrigo);
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}