package br.com.unisinos.backend.service.recurso;

import br.com.unisinos.backend.domain.Recurso;
import br.com.unisinos.backend.mapper.RecursoMapper;
import br.com.unisinos.backend.repository.RecursoRepository;
import br.com.unisinos.backend.validator.UsuarioServiceValidator;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.RecursoRequest;
import org.openapitools.model.RecursoResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarRecursoService {

    private final RecursoMapper mapper;
    private final RecursoRepository repository;
    private final UsuarioServiceValidator usuarioServiceValidator;

    public RecursoResponse cadastrar(RecursoRequest request) {
        usuarioServiceValidator.verificarPermissaoMembroDaDefesa();
        Recurso recurso = mapper.toDomain(request);
        recurso = repository.save(recurso);
        return mapper.toResponse(recurso);
    }
}
