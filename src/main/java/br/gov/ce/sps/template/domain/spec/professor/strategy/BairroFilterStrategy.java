package br.gov.ce.sps.template.domain.spec.professor.strategy;

import br.gov.ce.sps.template.domain.filter.ProfessorFilter;
import br.gov.ce.sps.template.domain.model.Professor;
import br.gov.ce.sps.template.domain.spec.FilterStrategy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

public class BairroFilterStrategy implements FilterStrategy<ProfessorFilter, Professor> {

    @Override
    public void apply(ProfessorFilter filtro, Root<Professor> root, CriteriaQuery<?> query, CriteriaBuilder builder, List<Predicate> predicates) {
        Optional.ofNullable(filtro.getBairro())
                .map(String::toLowerCase)
                .ifPresent(bairro -> predicates.add(builder.like(builder.lower(root.get("endereco").get("bairro")), "%" + bairro + "%")));
    }

}
