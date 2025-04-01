package br.gov.ce.sps.template.domain.repository;

import br.gov.ce.sps.template.domain.model.Disciplina;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DisciplinaRepository extends CustomJpaRepository<Disciplina, Long> {

    Optional<Disciplina> findByCodigo(UUID codigo);

    boolean existsByCodigo(UUID codigo);
}
