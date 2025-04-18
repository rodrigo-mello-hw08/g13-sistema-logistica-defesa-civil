package br.com.unisinos.backend.controller;

import br.com.unisinos.backend.service.abrigo.CadastrarRecursoAbrigo;
import org.openapitools.api.AbrigoApi;
import br.com.unisinos.backend.service.abrigo.CadastrarAbrigoService;
import br.com.unisinos.backend.service.abrigo.ListarAbrigosService;
import br.com.unisinos.backend.service.abrigo.ListarDetalhesAbrigoService;
import org.openapitools.model.AbrigoRecursoRequest;
import org.openapitools.model.AbrigoRequest;
import org.openapitools.model.AbrigoResponse;
import org.openapitools.model.DetalhesAbrigoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AbrigoController implements AbrigoApi {

    @Autowired
    private ListarAbrigosService listarAbrigosService;

    @Autowired
    private CadastrarAbrigoService cadastrarAbrigoService;

    @Autowired
    private CadastrarRecursoAbrigo cadastrarRecursoAbrigoService;

    @Autowired
    private ListarDetalhesAbrigoService listarDetalhesAbrigoService;

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
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<DetalhesAbrigoResponse> detalharAbrigo(Integer idAbrigo) {
        try {
            DetalhesAbrigoResponse body = listarDetalhesAbrigoService.detalhar(idAbrigo);
            return new ResponseEntity<>(body, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}