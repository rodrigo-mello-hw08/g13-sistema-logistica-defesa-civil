package br.com.unisinos.backend.factory;

import br.com.unisinos.backend.domain.NaturezaNotificacao;
import br.com.unisinos.backend.domain.Notificacao;
import lombok.experimental.UtilityClass;
import org.openapitools.model.NaturezaNotificacaoResponse;
import org.openapitools.model.NotificacaoResponse;

@UtilityClass
public class NotificacaoFactory {

    public static Notificacao enchente() {
        NaturezaNotificacao saude = NaturezaNotificacaoFactory.saude();
        return new Notificacao(1, "Enchente", saude);
    }

    public static NotificacaoResponse enchenteResponse() {
        NaturezaNotificacaoResponse saude = NaturezaNotificacaoFactory.saudeResponse();
        return new NotificacaoResponse().id(1)
            .descricao("Enchente")
            .naturezaNotificacao(saude);
    }
}