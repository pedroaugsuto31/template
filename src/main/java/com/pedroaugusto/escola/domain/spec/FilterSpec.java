package com.pedroaugusto.escola.domain.spec;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class FilterSpec {

    private FilterSpec() {
    }

    public static <T, U> Specification<U> execute(T filtro, List<FilterStrategy<T, U>> strategies) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            for (FilterStrategy<T, U> strategy : strategies) {
                strategy.apply(filtro, root, query, builder, predicates);
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
