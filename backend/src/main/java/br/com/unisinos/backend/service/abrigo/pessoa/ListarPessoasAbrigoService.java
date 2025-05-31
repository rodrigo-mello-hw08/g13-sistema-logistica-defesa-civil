package br.com.unisinos.backend.service.abrigo.pessoa;

import br.com.unisinos.backend.domain.Pessoa;
import br.com.unisinos.backend.mapper.PessoaMapper;
import br.com.unisinos.backend.repository.PessoaRepository;
import br.com.unisinos.backend.validator.AbrigoServiceValidator;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.PessoaResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarPessoasAbrigoService {

    private final AbrigoServiceValidator abrigoServiceValidator;
    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    public List<PessoaResponse> listar(Integer idAbrigo) {
        abrigoServiceValidator.encontrarAbrigo(idAbrigo);
        List<Pessoa> pessoas = pessoaRepository.encontrarPessoasAbrigo(idAbrigo);

        return pessoas.stream()
            .map(pessoaMapper::toResponse)
            .toList();
    }
}