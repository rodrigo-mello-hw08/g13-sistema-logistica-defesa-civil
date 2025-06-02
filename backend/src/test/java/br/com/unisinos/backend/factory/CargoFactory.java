package br.com.unisinos.backend.factory;

import br.com.unisinos.backend.domain.Cargo;
import lombok.experimental.UtilityClass;
import org.openapitools.model.CargoUsuarioResponse;

@UtilityClass
public class CargoFactory {

    public static Cargo membro() {
        return new Cargo(2, "Membro da Defesa");
    }

    public static Cargo voluntario() {
        return new Cargo(1, "Voluntario");
    }

    public static CargoUsuarioResponse membroResponse() {
        return new CargoUsuarioResponse(2, "Membro da Defesa");
    }

    public static CargoUsuarioResponse voluntarioResponse() {
        return new CargoUsuarioResponse(1, "Voluntario");
    }
}
