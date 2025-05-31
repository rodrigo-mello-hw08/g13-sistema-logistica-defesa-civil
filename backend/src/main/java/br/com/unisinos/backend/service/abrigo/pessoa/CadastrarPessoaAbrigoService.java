package br.com.unisinos.backend.service.abrigo.pessoa;

import br.com.unisinos.backend.domain.Abrigo;
import br.com.unisinos.backend.domain.Pessoa;
import br.com.unisinos.backend.mapper.PessoaMapper;
import br.com.unisinos.backend.repository.AbrigoRepository;
import br.com.unisinos.backend.repository.PessoaRepository;
import br.com.unisinos.backend.validator.AbrigoServiceValidator;
import br.com.unisinos.backend.validator.UsuarioServiceValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.PessoaRequest;
import org.openapitools.model.PessoaResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarPessoaAbrigoService {

    private final UsuarioServiceValidator usuarioServiceValidator;
    private final AbrigoServiceValidator abrigoServiceValidator;
    private final PessoaMapper pessoaMapper;
    private final PessoaRepository pessoaRepository;
    private final AbrigoRepository abrigoRepository;

    @Transactional
    public PessoaResponse cadastrar(Integer idAbrigo, PessoaRequest request) {
        usuarioServiceValidator.verificarPermissaoMembroDaDefesa();
        Pessoa pessoa = pessoaMapper.toDomain(request);
        pessoa = pessoaRepository.save(pessoa);

        Abrigo abrigo = abrigoServiceValidator.encontrarAbrigo(idAbrigo);
        abrigo.getListaDePessoas().add(pessoa);
        abrigoRepository.save(abrigo);

        return pessoaMapper.toResponse(pessoa);
    }
}