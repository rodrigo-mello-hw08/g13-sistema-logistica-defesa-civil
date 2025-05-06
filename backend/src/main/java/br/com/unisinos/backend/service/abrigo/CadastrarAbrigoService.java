package br.com.unisinos.backend.service.abrigo;

import br.com.unisinos.backend.domain.Abrigo;
import br.com.unisinos.backend.mapper.AbrigoMapper;
import br.com.unisinos.backend.repository.AbrigoRepository;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.AbrigoRequest;
import org.openapitools.model.AbrigoResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarAbrigoService {

    private final AbrigoMapper abrigoMapper;
    private final AbrigoRepository repository;

    public AbrigoResponse cadastrar(AbrigoRequest request) {
        Abrigo abrigo = abrigoMapper.toDomain(request);
        abrigo = repository.save(abrigo);
        return abrigoMapper.toResponse(abrigo);
    }
}