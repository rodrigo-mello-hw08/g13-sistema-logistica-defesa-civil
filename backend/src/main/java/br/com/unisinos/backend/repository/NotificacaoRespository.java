package br.com.unisinos.backend.repository;

import br.com.unisinos.backend.domain.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacaoRespository extends JpaRepository<Notificacao, Integer> {
}
