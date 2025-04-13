package br.com.unisinos.backend.service.recurso;

import br.com.unisinos.backend.domain.Recurso;
import br.com.unisinos.backend.mapper.RecursoMapper;
import br.com.unisinos.backend.repository.RecursoRepository;
import org.openapitools.model.RecursoRequest;
import org.openapitools.model.RecursoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarRecursoService {

    @Autowired
    private RecursoMapper mapper;

    @Autowired
    private RecursoRepository repository;

    public RecursoResponse cadastrar(RecursoRequest request) {
        Recurso recurso = mapper.toDomain(request);
        recurso = repository.save(recurso);
        return mapper.toResponse(recurso);
    }
}
