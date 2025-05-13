package br.com.unisinos.backend.service.abrigo;

import br.com.unisinos.backend.domain.Abrigo;
import br.com.unisinos.backend.domain.Recurso;
import br.com.unisinos.backend.domain.RecursoAbrigo;
import br.com.unisinos.backend.exception.RegistroNaoEncontradoException;
import br.com.unisinos.backend.mapper.RecursoAbrigoMapper;
import br.com.unisinos.backend.repository.AbrigoRepository;
import br.com.unisinos.backend.repository.RecursoAbrigoRepository;
import br.com.unisinos.backend.validator.AbrigoServiceValidator;
import br.com.unisinos.backend.validator.RecursoServiceValidator;
import br.com.unisinos.backend.validator.UsuarioServiceValidator;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.AbrigoRecursoRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarRecursoAbrigoService {

    private final UsuarioServiceValidator usuarioServiceValidator;
    private final AbrigoServiceValidator abrigoValidator;
    private final RecursoServiceValidator recursoValidator;
    private final AbrigoRepository abrigoRepository;
    private final RecursoAbrigoRepository recursoAbrigoRepository;
    private final RecursoAbrigoMapper mapper;

    public void cadastrar(Integer idAbrigo, AbrigoRecursoRequest request) throws RegistroNaoEncontradoException {
        usuarioServiceValidator.verificarPermissaoMembroDaDefesa();
        RecursoAbrigo recursoAbrigo = mapper.toDomain(request);
        Abrigo abrigo = abrigoValidator.encontrarAbrigo(idAbrigo);
        recursoAbrigo.setAbrigo(abrigo);

        Recurso recurso = recursoValidator.encontrarRecurso(request.getIdRecurso());
        recursoAbrigo.setRecurso(recurso);

        recursoAbrigoRepository.save(recursoAbrigo);
    }

}