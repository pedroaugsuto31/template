package br.gov.ce.sps.template.domain.repository;

import br.gov.ce.sps.template.domain.model.Professor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfessorRepository extends CustomJpaRepository<Professor, Long> {

    Optional<Professor> findByCodigo(UUID codigo);
    Boolean existsByCpf(String cpf);

}
