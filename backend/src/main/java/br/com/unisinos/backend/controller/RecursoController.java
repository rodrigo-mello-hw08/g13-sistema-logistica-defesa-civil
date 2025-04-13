package br.com.unisinos.backend.controller;

import br.com.unisinos.backend.service.recurso.CadastrarRecursoService;
import br.com.unisinos.backend.service.recurso.ListarRecursosService;
import org.openapitools.api.RecursoApi;
import org.openapitools.model.RecursoRequest;
import org.openapitools.model.RecursoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecursoController implements RecursoApi {

    @Autowired
    private ListarRecursosService listarRecursosService;

    @Autowired
    private CadastrarRecursoService cadastrarRecursoService;

    @Override
    public ResponseEntity<List<RecursoResponse>> listarRecursos() {
        return ResponseEntity.ok(listarRecursosService.listar());
    }

    @Override
    public ResponseEntity<RecursoResponse> cadastrarRecurso(RecursoRequest recursoRequest) {
        RecursoResponse body = cadastrarRecursoService.cadastrar(recursoRequest);
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }

}