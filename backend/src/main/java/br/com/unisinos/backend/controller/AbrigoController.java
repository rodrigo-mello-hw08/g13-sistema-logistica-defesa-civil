package br.com.unisinos.backend.controller;

import org.openapitools.api.AbrigoApi;
import br.com.unisinos.backend.service.abrigo.CadastrarAbrigoService;
import br.com.unisinos.backend.service.abrigo.ListarAbrigosService;
import org.openapitools.model.AbrigoRequest;
import org.openapitools.model.AbrigoResponse;
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

    @Override
    public ResponseEntity<List<AbrigoResponse>> listarAbrigos() {
        return ResponseEntity.ok(listarAbrigosService.listarAbrigos());
    }

    @Override
    public ResponseEntity<AbrigoResponse> cadastrarAbrigo(@RequestBody @Valid AbrigoRequest request) {
        AbrigoResponse body = cadastrarAbrigoService.cadastrar(request);
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }

}