package br.com.unisinos.backend.repository;

import br.com.unisinos.backend.domain.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecursoRepository extends JpaRepository<Recurso, Integer> {
}
