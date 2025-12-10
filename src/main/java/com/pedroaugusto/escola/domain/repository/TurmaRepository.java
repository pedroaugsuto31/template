package com.pedroaugusto.escola.domain.repository;

import com.pedroaugusto.escola.domain.model.Turma;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TurmaRepository extends CustomJpaRepository<Turma, Long> {

    Optional<Turma> findByCodigo(UUID codigo);
}
