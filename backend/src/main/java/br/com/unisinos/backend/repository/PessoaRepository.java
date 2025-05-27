package br.com.unisinos.backend.repository;

import br.com.unisinos.backend.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    @Query(""" 
              SELECT p 
              FROM Pessoa p 
              INNER JOIN PessoaAbrigo pa 
                ON pa.id_pessoa = p.id 
              WHERE pa.abrigo.id = :idAbrigo
          """)
    List<Pessoa> encontrarPessoasAbrigo(@Param("idAbrigo") Integer idAbrigo);
}
