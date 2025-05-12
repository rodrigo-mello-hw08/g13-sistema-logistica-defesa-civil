package br.com.unisinos.backend.repository;

import br.com.unisinos.backend.domain.NaturezaNotificacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NaturezaNotificacaoRepository extends JpaRepository<NaturezaNotificacao, Integer> {
}
