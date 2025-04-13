package br.com.unisinos.backend.controller;

import br.com.unisinos.backend.controller.request.AbrigoRequest;
import br.com.unisinos.backend.controller.response.AbrigoResponse;
import br.com.unisinos.backend.service.abrigo.CadastrarAbrigoService;
import br.com.unisinos.backend.service.abrigo.ListarAbrigosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/abrigo")
public class AbrigoController {

    @Autowired
    private ListarAbrigosService listarAbrigosService;

    @Autowired
    private CadastrarAbrigoService cadastrarAbrigoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AbrigoResponse> listarAbrigos() {
        return listarAbrigosService.listarAbrigos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AbrigoResponse criarAbrigo(@RequestBody @Valid AbrigoRequest request) {
        return cadastrarAbrigoService.cadastrar(request);
    }

}