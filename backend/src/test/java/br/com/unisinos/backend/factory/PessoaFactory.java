package br.com.unisinos.backend.factory;

import br.com.unisinos.backend.domain.Pessoa;
import lombok.experimental.UtilityClass;
import org.openapitools.model.PessoaDetalhadaResponse;
import org.openapitools.model.PessoaResponse;

import java.time.LocalDate;
import java.util.List;

@UtilityClass
public class PessoaFactory {

    public static Pessoa augusto() {
        return Pessoa.builder()
            .id(10)
            .cpf("02449856732")
            .nome("Augusto")
            .dataNascimento(LocalDate.now())
            .endereco("Rua do sol")
            .build();
    }

    public static PessoaResponse augustoResponse() {
        return new PessoaResponse()
            .id(10)
            .cpf("02449856732")
            .nome("Augusto")
            .dataNascimento(LocalDate.now())
            .endereco("Rua do sol");
    }

    public static PessoaDetalhadaResponse augustoDetalhado() {
        return new PessoaDetalhadaResponse()
            .id(10)
            .cpf("02449856732")
            .nome("Augusto")
            .dataNascimento(LocalDate.now())
            .endereco("Rua do sol")
            .idAbrigos(List.of(1));
    }
}
