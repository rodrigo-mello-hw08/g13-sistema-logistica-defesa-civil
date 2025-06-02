package br.com.unisinos.backend.factory;

import br.com.unisinos.backend.domain.Abrigo;
import lombok.experimental.UtilityClass;
import org.openapitools.model.AbrigoRequest;
import org.openapitools.model.AbrigoResponse;

@UtilityClass
public class AbrigoFactory {

    public static AbrigoRequest ginasioRequest() {
        return new AbrigoRequest()
            .nome("Ginasio Municipal Santa Fe")
            .localizacao("Rua Santa Fe 204");
    }

    public static Abrigo ginasio() {
        return Abrigo.builder()
            .id(30)
            .nome("Ginasio Municipal Santa Fe")
            .localizacao("Rua Santa Fe 204")
            .listaDeRecursos(RecursoFactory.listaRecursos())
            .build();
    }

    public static AbrigoResponse ginasioResponse() {
        return new AbrigoResponse()
            .id(30)
            .nome("Ginasio Municipal Santa Fe")
            .localizacao("Rua Santa Fe 204");
    }
}