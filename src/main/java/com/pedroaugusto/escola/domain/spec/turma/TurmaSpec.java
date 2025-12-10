package com.pedroaugusto.escola.domain.spec.turma;

import com.pedroaugusto.escola.domain.filter.TurmaFilter;
import com.pedroaugusto.escola.domain.model.Turma;
import com.pedroaugusto.escola.domain.spec.FilterSpec;
import com.pedroaugusto.escola.domain.spec.FilterStrategy;
import com.pedroaugusto.escola.domain.spec.turma.strategy.DiasFilterStrategy;
import com.pedroaugusto.escola.domain.spec.turma.strategy.NomeFilterStrategy;
import com.pedroaugusto.escola.domain.spec.turma.strategy.TurnoFilterStrategy;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class TurmaSpec {

    private TurmaSpec() {
    }

    public static Specification<Turma> usandoFiltro(TurmaFilter filtro) {
        List<FilterStrategy<TurmaFilter, Turma>> strategies = List.of(
                new NomeFilterStrategy(),
                new DiasFilterStrategy(),
                new TurnoFilterStrategy()
        );
        return FilterSpec.execute(filtro, strategies);
    }

}
