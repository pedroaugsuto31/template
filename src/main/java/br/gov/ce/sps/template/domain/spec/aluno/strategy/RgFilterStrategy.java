package br.gov.ce.sps.template.domain.spec.aluno.strategy;

import br.gov.ce.sps.template.domain.filter.AlunoFilter;
import br.gov.ce.sps.template.domain.model.Aluno;
import br.gov.ce.sps.template.domain.spec.FilterStrategy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

public class RgFilterStrategy implements FilterStrategy<AlunoFilter, Aluno> {

    @Override
    public void apply(AlunoFilter filtro, Root<Aluno> root, CriteriaQuery<?> query, CriteriaBuilder builder, List<Predicate> predicates) {
        Optional.ofNullable(filtro.getRg())
                .map(String::strip)
                .ifPresent(rg -> predicates.add(builder.equal(root.get("rg"), rg)));
    }

}
