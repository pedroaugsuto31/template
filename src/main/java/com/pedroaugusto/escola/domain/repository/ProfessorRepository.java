package com.pedroaugusto.escola.domain.repository;

import com.pedroaugusto.escola.domain.model.Professor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfessorRepository extends CustomJpaRepository<Professor, Long> {

    Optional<Professor> findByCodigo(UUID codigo);

    Boolean existsByCpf(String cpf);

}
