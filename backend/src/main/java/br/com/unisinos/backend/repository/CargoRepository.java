package br.com.unisinos.backend.repository;


import br.com.unisinos.backend.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}