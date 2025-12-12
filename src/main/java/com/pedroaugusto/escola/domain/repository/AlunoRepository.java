package com.pedroaugusto.escola.domain.repository;

import com.pedroaugusto.escola.domain.model.Aluno;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AlunoRepository extends CustomJpaRepository<Aluno, Long> {

    Optional<Aluno> findByCodigo(UUID codigo);

    Boolean existsByCpf(String cpf);

}
