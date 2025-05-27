package br.com.unisinos.backend.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "tb_usuario")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String email;

    private String senha;

    @ManyToOne
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;

    private String nome;

    private String cpf;

    private String endereco;

}