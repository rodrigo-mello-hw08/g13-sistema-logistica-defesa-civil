package br.com.unisinos.backend.factory;

import br.com.unisinos.backend.domain.Recurso;
import lombok.experimental.UtilityClass;
import org.openapitools.model.RecursoResponse;

import java.util.Arrays;
import java.util.List;

@UtilityClass
public class RecursoFactory {

    public static Recurso agua() {
        return Recurso.builder()
            .id(30)
            .nome("Agua")
            .build();
    }

    public static Recurso cobertor() {
        return Recurso.builder()
            .id(32)
            .nome("Cobertor")
            .build();
    }

    public static RecursoResponse aguaResponse() {
        return new RecursoResponse()
            .id(30)
            .nome("Agua");
    }

    public static RecursoResponse cobertorResponse() {
        return new RecursoResponse()
            .id(32)
            .nome("Cobertor");
    }

    public static List<Recurso> listaRecursos() {
        return Arrays.asList(agua(), cobertor());
    }
}
