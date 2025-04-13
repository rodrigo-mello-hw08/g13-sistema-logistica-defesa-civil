package br.com.unisinos.backend.service.abrigo;

import br.com.unisinos.backend.domain.Abrigo;
import br.com.unisinos.backend.exception.RegistroNaoEncontradoException;
import br.com.unisinos.backend.mapper.AbrigoMapper;
import br.com.unisinos.backend.mapper.RecursoMapper;
import br.com.unisinos.backend.validator.AbrigoServiceValidator;
import org.openapitools.model.DetalhesAbrigoResponse;
import org.openapitools.model.RecursoDetalhadoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarDetalhesAbrigoService {

    @Autowired
    private AbrigoServiceValidator abrigoValidator;

    @Autowired
    private AbrigoMapper abrigoMapper;

    @Autowired
    private RecursoMapper recursoMapper;

    public DetalhesAbrigoResponse detalhar(Integer idAbrigo) throws RegistroNaoEncontradoException {
        Abrigo abrigo = abrigoValidator.encontrarAbrigo(idAbrigo);
        DetalhesAbrigoResponse response = abrigoMapper.toDetalheAbrigo(abrigo);
        List<RecursoDetalhadoResponse> recursos = abrigo.getRecursos()
            .stream()
            .map(r -> recursoMapper.toResponseRecursoDetalhe(r))
            .collect(Collectors.toList());
        response.setRecursos(recursos);
        return response;
    }

}
