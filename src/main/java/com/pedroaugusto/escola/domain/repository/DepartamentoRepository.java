package com.pedroaugusto.escola.domain.repository;

import com.pedroaugusto.escola.domain.model.Departamento;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DepartamentoRepository extends CustomJpaRepository<Departamento, Long> {

    Optional<Departamento> findByCodigo(UUID codigo);

}
