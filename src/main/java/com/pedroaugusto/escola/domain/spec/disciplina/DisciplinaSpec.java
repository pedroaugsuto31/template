package com.pedroaugusto.escola.domain.spec.disciplina;

import com.pedroaugusto.escola.domain.filter.DisciplinaFilter;
import com.pedroaugusto.escola.domain.model.Disciplina;
import com.pedroaugusto.escola.domain.spec.FilterSpec;
import com.pedroaugusto.escola.domain.spec.FilterStrategy;
import com.pedroaugusto.escola.domain.spec.disciplina.strategy.CargaHorariaFilterStrategy;
import com.pedroaugusto.escola.domain.spec.disciplina.strategy.NomeFilterStrategy;
import com.pedroaugusto.escola.domain.spec.disciplina.strategy.NumeroAlunosFilterStrategy;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class DisciplinaSpec {

    private DisciplinaSpec() {
    }

    public static Specification<Disciplina> usandoFiltro(DisciplinaFilter filtro) {
        List<FilterStrategy<DisciplinaFilter, Disciplina>> strategies = List.of(
                new NomeFilterStrategy(),
                new CargaHorariaFilterStrategy(),
                new NumeroAlunosFilterStrategy()
        );
        return FilterSpec.execute(filtro, strategies);
    }

}
