package br.com.unisinos.backend.controller.response;

import lombok.Data;

@Data
public class AbrigoResponse {
    private Integer id;
    private String nome;
    private String localizacao;
}