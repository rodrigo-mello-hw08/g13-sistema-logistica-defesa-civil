package br.com.unisinos.backend.service.notificacao;

import br.com.unisinos.backend.mapper.NotificacaoMapper;
import br.com.unisinos.backend.repository.NotificacaoRespository;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.NotificacaoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarNotificacoesService {

    private final NotificacaoRespository respository;
    private final NotificacaoMapper mapper;

    public List<NotificacaoResponse> listar() {
        return respository.findAll()
            .stream()
            .map(mapper::toResponse)
            .toList();
    }
}