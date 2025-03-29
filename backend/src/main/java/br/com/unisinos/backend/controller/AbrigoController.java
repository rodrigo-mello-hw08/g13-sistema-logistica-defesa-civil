package br.com.unisinos.backend.controller;

import br.com.unisinos.backend.controller.response.AbrigoResponse;
import br.com.unisinos.backend.service.abrigo.ListarAbrigosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/abrigo")
public class AbrigoController {

    @Autowired
    private ListarAbrigosService listarAbrigosService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AbrigoResponse> listarAbrigos() {
        return listarAbrigosService.listarAbrigos();
    }

}