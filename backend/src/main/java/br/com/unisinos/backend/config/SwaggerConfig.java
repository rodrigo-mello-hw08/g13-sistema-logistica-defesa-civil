package br.com.unisinos.backend.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
            .info(getInfo())
            .servers(getServers())
            .externalDocs(getExternalDocs());
    }

    private static Info getInfo() {
        return new Info()
            .title("G13 Sistema Logistica Defesa Civil")
            .description("Trabalho da cadeira de sistemas digitais")
            .version("v1.0.0");
    }

    private static List<Server> getServers() {
        Server server = new Server().url("http://localhost:8080").description("Servidor local");
        return Collections.singletonList(server);
    }

    private static ExternalDocumentation getExternalDocs() {
        return new ExternalDocumentation()
            .description("SpringShop Wiki Documentation")
            .url("https://springshop.wiki.github.org/docs");
    }

}