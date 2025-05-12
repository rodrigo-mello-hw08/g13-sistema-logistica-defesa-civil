package br.com.unisinos.backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "tb_recurso")
@Entity
@ToString(exclude = {"abrigos"})
@EqualsAndHashCode(exclude = {"abrigos"})
public class Recurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "recurso", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<RecursoAbrigo> abrigos = new ArrayList<>();
}