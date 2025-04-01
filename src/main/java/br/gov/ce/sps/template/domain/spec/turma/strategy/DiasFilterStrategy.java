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

public class DiasFilterStrategy implements FilterStrategy<TurmaFilter, Turma> {

    @Override
    public void apply(TurmaFilter filtro, Root<Turma> root, CriteriaQuery<?> query, CriteriaBuilder builder, List<Predicate> predicates) {
        Optional.ofNullable(filtro.getDias())
                .filter(dias -> !dias.isEmpty())
                .ifPresent(dias -> predicates.add(builder.and(builder.and(dias.stream()
                        .map(dia -> builder.isMember(dia, root.get("dias")))
                        .toArray(Predicate[]::new)), builder.equal(builder.size(root.get("dias")), dias.size()))));
    }

}
