package br.com.unisinos.backend.service.abrigo;

import br.com.unisinos.backend.controller.response.AbrigoResponse;
import br.com.unisinos.backend.domain.Abrigo;
import br.com.unisinos.backend.mapper.AbrigoMapper;
import br.com.unisinos.backend.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarAbrigosService {

    @Autowired
    private AbrigoRepository repository;

    @Autowired
    private AbrigoMapper mapper;

    public List<AbrigoResponse> listarAbrigos() {
        List<Abrigo> abrigos = repository.findAll();
        return abrigos.stream()
            .map(mapper::toResponse)
            .collect(Collectors.toList());
    }
}