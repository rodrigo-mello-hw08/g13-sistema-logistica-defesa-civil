package br.com.unisinos.backend.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_notificacao")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_natureza_notificacao")
    private NaturezaNotificacao natureza;
}
