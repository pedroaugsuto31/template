package com.pedroaugusto.escola.domain.spec.disciplina.strategy;

import com.pedroaugusto.escola.domain.filter.DisciplinaFilter;
import com.pedroaugusto.escola.domain.model.Disciplina;
import com.pedroaugusto.escola.domain.spec.FilterStrategy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

public class NomeFilterStrategy implements FilterStrategy<DisciplinaFilter, Disciplina> {

    @Override
    public void apply(DisciplinaFilter filtro, Root<Disciplina> root, CriteriaQuery<?> query, CriteriaBuilder builder, List<Predicate> predicates) {
        Optional.ofNullable(filtro.getNome())
                .map(String::toLowerCase)
                .ifPresent(nome -> predicates.add(builder.like(builder.lower(root.get("nome")), "%" + nome + "%")));
    }

}
