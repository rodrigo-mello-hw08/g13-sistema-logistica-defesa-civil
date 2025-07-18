package br.com.unisinos.backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_natureza_notificacao")
public class NaturezaNotificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String natureza;

    @OneToMany(mappedBy = "natureza", fetch = FetchType.LAZY)
    private List<Notificacao> notificacoes;
}
