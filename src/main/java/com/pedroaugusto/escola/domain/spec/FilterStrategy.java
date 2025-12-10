package com.pedroaugusto.escola.domain.spec;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public interface FilterStrategy<T, U> {

    void apply(T filtro, Root<U> root, CriteriaQuery<?> query, CriteriaBuilder builder, List<Predicate> predicates);

}
