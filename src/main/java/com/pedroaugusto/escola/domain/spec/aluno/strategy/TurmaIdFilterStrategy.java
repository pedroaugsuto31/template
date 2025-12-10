package com.pedroaugusto.escola.domain.spec.aluno.strategy;

import com.pedroaugusto.escola.domain.filter.AlunoFilter;
import com.pedroaugusto.escola.domain.model.Aluno;
import com.pedroaugusto.escola.domain.spec.FilterStrategy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

public class TurmaIdFilterStrategy implements FilterStrategy<AlunoFilter, Aluno> {

    @Override
    public void apply(AlunoFilter filtro, Root<Aluno> root, CriteriaQuery<?> query, CriteriaBuilder builder, List<Predicate> predicates) {
        Optional.ofNullable(filtro.getTurmaId())
                .ifPresent(turma -> predicates.add(builder.equal(root.get("turma").get("id"), turma)));
    }

}
