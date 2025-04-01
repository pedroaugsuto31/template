package br.gov.ce.sps.template.domain.spec.disciplina.strategy;

import br.gov.ce.sps.template.domain.filter.DisciplinaFilter;
import br.gov.ce.sps.template.domain.model.Disciplina;
import br.gov.ce.sps.template.domain.spec.FilterStrategy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

public class NumeroAlunosFilterStrategy implements FilterStrategy<DisciplinaFilter, Disciplina> {

    @Override
    public void apply(DisciplinaFilter filtro, Root<Disciplina> root, CriteriaQuery<?> query, CriteriaBuilder builder, List<Predicate> predicates) {
        Optional.ofNullable(filtro.getNumeroAlunos())
                .ifPresent(numeroAlunos -> predicates.add(builder.equal(root.get("numeroAlunos"), numeroAlunos)));
    }

}
