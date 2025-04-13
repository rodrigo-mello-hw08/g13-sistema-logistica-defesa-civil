package br.com.unisinos.backend.service.recurso;

import br.com.unisinos.backend.domain.Recurso;
import br.com.unisinos.backend.mapper.RecursoMapper;
import br.com.unisinos.backend.repository.RecursoRepository;
import org.openapitools.model.RecursoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarRecursosService {

    @Autowired
    private RecursoMapper mapper;

    @Autowired
    private RecursoRepository repository;

    public List<RecursoResponse> listar() {
        List<Recurso> recursos = repository.findAll();
        return recursos.stream()
            .map(mapper::toResponse)
            .collect(Collectors.toList());
    }
}