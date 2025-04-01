package br.gov.ce.sps.template.domain.repository;

import br.gov.ce.sps.template.domain.model.Curso;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CursoRepository extends CustomJpaRepository<Curso, Long> {

    Optional<Curso> findByCodigo(UUID codigo);

}
