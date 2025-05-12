package br.com.unisinos.backend.repository;

import br.com.unisinos.backend.domain.Abrigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbrigoRepository extends JpaRepository<Abrigo, Integer> {

}