package br.com.unisinos.backend.repository;

import br.com.unisinos.backend.domain.Abrigo;
import br.com.unisinos.backend.domain.PessoaAbrigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PessoaAbrigoRepository extends JpaRepository<PessoaAbrigo, Integer> {

    @Query(""" 
              SELECT a 
              FROM PessoaAbrigo pa
              INNER JOIN Pessoa p 
                ON pa.pessoa.id = p.id 
              INNER JOIN Abrigo a
                ON pa.abrigo.id = a.id
              WHERE pa.pessoa.id = :idPessoa
                AND pa.flAtivo = 'S'
          """)
    List<Abrigo> encontrarAbrigosPessoa(@Param("idPessoa") Integer idPessoa);
}