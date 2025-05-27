package br.com.unisinos.backend.factory;

import br.com.unisinos.backend.domain.Cargo;
import br.com.unisinos.backend.domain.Usuario;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UsuarioFactory {

    public static Usuario membroDaDefesa() {
        return Usuario.builder()
            .id(100)
            .cpf("77762255095")
            .cargo(cargoMembro())
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
            .cargo(cargoVoluntario())
            .nome("Rodrigo Mello")
            .email("rodrigo.mello@gmail.com.br")
            .senha("bn22ldc34jlmc3a")
            .endereco("Rua Carlos Augusto de Souza 220")
            .build();
    }

    private static Cargo cargoMembro() {
        return new Cargo(2, "Membro da Defesa");
    }

    private static Cargo cargoVoluntario() {
        return new Cargo(1, "Voluntario");
    }

}