package br.gov.ce.sps.template.domain.spec.disciplina;

import br.gov.ce.sps.template.domain.filter.DisciplinaFilter;
import br.gov.ce.sps.template.domain.model.Disciplina;
import br.gov.ce.sps.template.domain.spec.FilterSpec;
import br.gov.ce.sps.template.domain.spec.FilterStrategy;
import br.gov.ce.sps.template.domain.spec.disciplina.strategy.CargaHorariaFilterStrategy;
import br.gov.ce.sps.template.domain.spec.disciplina.strategy.NomeFilterStrategy;
import br.gov.ce.sps.template.domain.spec.disciplina.strategy.NumeroAlunosFilterStrategy;
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
