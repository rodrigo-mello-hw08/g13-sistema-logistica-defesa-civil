package br.com.unisinos.backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tb_pessoa")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String nome;

    private LocalDate dataNascimento;

    @Column(length = 11, columnDefinition = "CHAR(11)")
    private String cpf;

    private String endereco;
}
