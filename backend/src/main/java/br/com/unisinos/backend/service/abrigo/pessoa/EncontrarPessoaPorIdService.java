package br.com.unisinos.backend.service.abrigo.pessoa;

import br.com.unisinos.backend.domain.Abrigo;
import br.com.unisinos.backend.domain.Pessoa;
import br.com.unisinos.backend.mapper.PessoaMapper;
import br.com.unisinos.backend.repository.PessoaAbrigoRepository;
import br.com.unisinos.backend.validator.PessoaServiceValidator;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.PessoaDetalhadaResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EncontrarPessoaPorIdService {

    private final PessoaServiceValidator pessoaServiceValidator;
    private final PessoaAbrigoRepository pessoaAbrigoRepository;
    private final PessoaMapper pessoaMapper;

    public PessoaDetalhadaResponse encontrarPessoa(Integer idPessoa) {
        Pessoa pessoa = pessoaServiceValidator.encontrarPessoa(idPessoa);

        List<Abrigo> abrigos = pessoaAbrigoRepository.encontrarAbrigosPessoa(idPessoa);
        PessoaDetalhadaResponse pessoaDetalhada = pessoaMapper.toPessoaDetalhada(pessoa);
        List<Integer> idsAbrigo = abrigos.stream().map(Abrigo::getId).toList();
        pessoaDetalhada.setIdAbrigos(idsAbrigo);

        return pessoaDetalhada;
    }
}