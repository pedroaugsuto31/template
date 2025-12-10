package com.pedroaugusto.escola.domain.repository;

import com.pedroaugusto.escola.domain.model.Disciplina;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DisciplinaRepository extends CustomJpaRepository<Disciplina, Long> {

    Optional<Disciplina> findByCodigo(UUID codigo);

    boolean existsByCodigo(UUID codigo);
}
