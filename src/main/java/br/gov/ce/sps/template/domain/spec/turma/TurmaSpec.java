package br.gov.ce.sps.template.domain.spec.turma;

import br.gov.ce.sps.template.domain.filter.TurmaFilter;
import br.gov.ce.sps.template.domain.model.Turma;
import br.gov.ce.sps.template.domain.spec.FilterSpec;
import br.gov.ce.sps.template.domain.spec.FilterStrategy;
import br.gov.ce.sps.template.domain.spec.turma.strategy.DiasFilterStrategy;
import br.gov.ce.sps.template.domain.spec.turma.strategy.NomeFilterStrategy;
import br.gov.ce.sps.template.domain.spec.turma.strategy.TurnoFilterStrategy;
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
