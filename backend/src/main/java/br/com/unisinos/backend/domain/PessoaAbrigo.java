package br.com.unisinos.backend.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "tb_pessoa_abrigo")
@Entity
public class PessoaAbrigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_abrigo", nullable = false)
    private Abrigo abrigo;

    @ManyToOne
    @JoinColumn(name = "id_pessoa", nullable = false)
    private Pessoa pessoa;

    @Column(length = 1, columnDefinition = "CHAR(1)")
    @Enumerated(EnumType.STRING)
    private FlagAtivo flAtivo;
}
