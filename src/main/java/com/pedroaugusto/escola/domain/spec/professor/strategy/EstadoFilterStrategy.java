package com.pedroaugusto.escola.domain.spec.professor.strategy;

import com.pedroaugusto.escola.domain.filter.ProfessorFilter;
import com.pedroaugusto.escola.domain.model.Professor;
import com.pedroaugusto.escola.domain.spec.FilterStrategy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

public class EstadoFilterStrategy implements FilterStrategy<ProfessorFilter, Professor> {

    @Override
    public void apply(ProfessorFilter filtro, Root<Professor> root, CriteriaQuery<?> query, CriteriaBuilder builder, List<Predicate> predicates) {
        Optional.ofNullable(filtro.getEstado())
                .map(String::toLowerCase)
                .ifPresent(estado -> predicates.add(builder.like(builder.lower(root.get("endereco").get("estado")), "%" + estado + "%")));

    }

}
