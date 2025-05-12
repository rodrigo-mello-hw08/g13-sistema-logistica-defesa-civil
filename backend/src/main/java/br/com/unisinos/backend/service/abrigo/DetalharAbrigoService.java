package br.com.unisinos.backend.service.abrigo;

import br.com.unisinos.backend.domain.Abrigo;
import br.com.unisinos.backend.exception.RegistroNaoEncontradoException;
import br.com.unisinos.backend.mapper.AbrigoMapper;
import br.com.unisinos.backend.mapper.RecursoMapper;
import br.com.unisinos.backend.validator.AbrigoServiceValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.model.DetalhesAbrigoResponse;
import org.openapitools.model.RecursoDetalhadoResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class DetalharAbrigoService {

    private final AbrigoServiceValidator abrigoValidator;
    private final AbrigoMapper abrigoMapper;
    private final RecursoMapper recursoMapper;

    public DetalhesAbrigoResponse detalhar(Integer idAbrigo) throws RegistroNaoEncontradoException {
        Abrigo abrigo = abrigoValidator.encontrarAbrigo(idAbrigo);
        DetalhesAbrigoResponse response = abrigoMapper.toDetalheAbrigo(abrigo);
        List<RecursoDetalhadoResponse> recursos = abrigo.getDetalhesRecursos()
            .stream()
            .map(r -> recursoMapper.toResponseRecursoDetalhe(r))
            .collect(Collectors.toList());
        response.setRecursos(recursos);
        return response;
    }
}