package br.com.unisinos.backend.mapper;

import br.com.unisinos.backend.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.openapitools.model.PessoaRequest;
import org.openapitools.model.PessoaResponse;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PessoaMapper {

    private final ModelMapper modelMapper;

    public Pessoa toDomain(PessoaRequest request) {
        return modelMapper.map(request, Pessoa.class);
    }

    public PessoaResponse toResponse(Pessoa domain) {
        return modelMapper.map(domain, PessoaResponse.class);
    }
}