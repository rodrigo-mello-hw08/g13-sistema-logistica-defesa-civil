package br.com.unisinos.backend.service.natureza.notificacao;

import br.com.unisinos.backend.mapper.NaturezaNotificacaoMapper;
import br.com.unisinos.backend.repository.NaturezaNotificacaoRepository;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.NaturezaNotificacaoResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListarNaturezasNotificacaoService {

    private final NaturezaNotificacaoRepository repository;
    private final NaturezaNotificacaoMapper mapper;

    public List<NaturezaNotificacaoResponse> listar() {
        return repository.findAll()
            .stream()
            .map(mapper::toResponse)
            .toList();
    }
}