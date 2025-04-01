package br.gov.ce.sps.template.domain.repository;

import br.gov.ce.sps.template.domain.model.Turma;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TurmaRepository extends CustomJpaRepository<Turma, Long> {

    Optional<Turma> findByCodigo(UUID codigo);
}
