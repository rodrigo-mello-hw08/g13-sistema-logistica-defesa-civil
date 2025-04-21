package br.com.unisinos.backend.service.natureza.notificacao;

import br.com.unisinos.backend.mapper.NaturezaNotificacaoMapper;
import br.com.unisinos.backend.repository.NaturezaNotificacaoRepository;
import org.openapitools.model.NaturezaNotificacaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarNaturezasNotificacaoService {

    @Autowired
    private NaturezaNotificacaoRepository repository;

    @Autowired
    private NaturezaNotificacaoMapper mapper;

    public List<NaturezaNotificacaoResponse> listar() {
        return repository.findAll()
            .stream()
            .map(mapper::toResponse)
            .collect(Collectors.toList());
    }
}