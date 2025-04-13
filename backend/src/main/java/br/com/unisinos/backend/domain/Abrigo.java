package br.com.unisinos.backend.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "tb_abrigo")
@Entity
public class Abrigo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String nome;

    private String localizacao;

    @OneToMany(mappedBy = "abrigo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<RecursoAbrigo> recursos = new ArrayList<>();
}