package br.com.unisinos.backend.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class AbrigoRequest {
    @NotEmpty
    private String nome;
    @NotEmpty
    private String localizacao;
}
