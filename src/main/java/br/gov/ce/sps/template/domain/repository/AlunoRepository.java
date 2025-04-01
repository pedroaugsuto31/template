package br.gov.ce.sps.template.domain.repository;

import br.gov.ce.sps.template.domain.model.Aluno;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AlunoRepository extends CustomJpaRepository<Aluno, Long> {

    Optional<Aluno> findByCodigo(UUID codigo);
    Boolean existsByCpf(String cpf);

}
