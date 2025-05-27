package br.com.unisinos.backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tb_abrigo")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String nome;

    private LocalDate data_nascimento;

    private String cpf;

    private String endereco;
}
