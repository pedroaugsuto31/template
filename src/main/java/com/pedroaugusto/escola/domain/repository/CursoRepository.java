package com.pedroaugusto.escola.domain.repository;

import com.pedroaugusto.escola.domain.model.Curso;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CursoRepository extends CustomJpaRepository<Curso, Long> {

    Optional<Curso> findByCodigo(UUID codigo);

}
