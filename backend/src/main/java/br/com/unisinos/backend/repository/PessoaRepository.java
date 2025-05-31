package br.com.unisinos.backend.repository;

import br.com.unisinos.backend.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    @Query(""" 
              SELECT p 
              FROM Pessoa p 
              INNER JOIN PessoaAbrigo pa 
                ON pa.pessoa.id = p.id 
              WHERE pa.abrigo.id = :idAbrigo
          """)
    List<Pessoa> encontrarPessoasAbrigo(@Param("idAbrigo") Integer idAbrigo);
}
