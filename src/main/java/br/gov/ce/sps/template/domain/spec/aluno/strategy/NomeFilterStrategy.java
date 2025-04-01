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

public class NomeFilterStrategy implements FilterStrategy<AlunoFilter, Aluno> {

    @Override
    public void apply(AlunoFilter filtro, Root<Aluno> root, CriteriaQuery<?> query, CriteriaBuilder builder, List<Predicate> predicates) {
        Optional.ofNullable(filtro.getNome())
                .map(String::toLowerCase)
                .ifPresent(nome -> predicates.add(builder.like(builder.lower(root.get("nome")), "%" + nome + "%")));
    }

}
