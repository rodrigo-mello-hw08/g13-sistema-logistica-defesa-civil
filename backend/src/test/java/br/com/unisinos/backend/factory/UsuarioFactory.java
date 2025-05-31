package br.com.unisinos.backend.factory;

import br.com.unisinos.backend.domain.Usuario;
import lombok.experimental.UtilityClass;
import org.openapitools.model.CadastroUsuarioRequest;
import org.openapitools.model.UsuarioResponse;

@UtilityClass
public class UsuarioFactory {

    public static CadastroUsuarioRequest voluntarioRequest() {
        return new CadastroUsuarioRequest()
                .cpf("77762255095")
                .idCargo(1)
                .nome("Alisson G")
                .email("alisson@gmail.com.br")
                .senha("undauc239mca")
                .endereco("Rua Pery Luiz de Freitas 383");
    }

    public static Usuario membroDaDefesa() {
        return Usuario.builder()
            .id(100)
            .cpf("77762255095")
            .cargo(CargoFactory.membro())
            .nome("Alisson G")
            .email("alisson@gmail.com.br")
            .senha("undauc239mca")
            .endereco("Rua Pery Luiz de Freitas 383")
            .build();
    }

    public static Usuario voluntario() {
        return Usuario.builder()
            .id(101)
            .cpf("08532794033")
            .cargo(CargoFactory.voluntario())
            .nome("Rodrigo Mello")
            .email("rodrigo.mello@gmail.com.br")
            .senha("bn22ldc34jlmc3a")
            .endereco("Rua Carlos Augusto de Souza 220")
            .build();
    }

    public static UsuarioResponse voluntarioResponse() {
        return new UsuarioResponse()
            .id(101)
            .cargo("Voluntario")
            .nome("Rodrigo Mello")
            .email("rodrigo.mello@gmail.com.br");
    }

}