package br.com.unisinos.backend.factory;

import br.com.unisinos.backend.domain.NaturezaNotificacao;
import lombok.experimental.UtilityClass;
import org.openapitools.model.NaturezaNotificacaoResponse;

@UtilityClass
public class NaturezaNotificacaoFactory {

    public static NaturezaNotificacao saude() {
        return NaturezaNotificacao.builder()
            .id(1)
            .natureza("Saúde")
            .build();
    }

    public static NaturezaNotificacaoResponse saudeResponse() {
        return new NaturezaNotificacaoResponse().id(1).natureza("Saúde");
    }
}