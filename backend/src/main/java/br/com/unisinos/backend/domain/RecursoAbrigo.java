package br.com.unisinos.backend.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "tb_recurso_abrigo")
@Entity
public class RecursoAbrigo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_abrigo", nullable = false)
    private Abrigo abrigo;

    @ManyToOne
    @JoinColumn(name = "id_recurso", nullable = false)
    private Recurso recurso;

    private Integer quantidade;

    @Column(name = "unidade_medida")
    private String unidadeMedida;
}
