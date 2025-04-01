package br.gov.ce.sps.template.domain.spec.turma.strategy;

import br.gov.ce.sps.template.domain.filter.TurmaFilter;
import br.gov.ce.sps.template.domain.model.Turma;
import br.gov.ce.sps.template.domain.spec.FilterStrategy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

public class TurnoFilterStrategy implements FilterStrategy<TurmaFilter, Turma> {
    @Override
    public void apply(TurmaFilter filtro, Root<Turma> root, CriteriaQuery<?> query, CriteriaBuilder builder, List<Predicate> predicates) {
        Optional.ofNullable(filtro.getTurno())
                .ifPresent(turno -> predicates.add(builder.equal(root.get("turno"), turno)));
    }
}
