package br.com.unisinos.backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "tb_abrigo")
@Entity
@ToString(exclude = {"detalhesRecursos", "listaDeRecursos"})
@EqualsAndHashCode(exclude = {"detalhesRecursos", "listaDeRecursos"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Abrigo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String nome;

    private String localizacao;

    @OneToMany(mappedBy = "abrigo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<RecursoAbrigo> detalhesRecursos = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "tb_recurso_abrigo",
        joinColumns = @JoinColumn(name = "id_abrigo"),
        inverseJoinColumns = @JoinColumn(name = "id_recurso"))
    private List<Recurso> listaDeRecursos;
}