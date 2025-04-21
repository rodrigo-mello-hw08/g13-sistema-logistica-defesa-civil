package br.com.unisinos.backend.service.abrigo;

import br.com.unisinos.backend.domain.Abrigo;
import br.com.unisinos.backend.mapper.AbrigoMapper;
import br.com.unisinos.backend.repository.AbrigoRepository;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.AbrigoResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListarAbrigosService {

    private final AbrigoRepository repository;
    private final AbrigoMapper mapper;

    public List<AbrigoResponse> listarAbrigos() {
        List<Abrigo> abrigos = repository.findAll();
        return abrigos.stream()
            .map(mapper::toResponse)
            .collect(Collectors.toList());
    }
}