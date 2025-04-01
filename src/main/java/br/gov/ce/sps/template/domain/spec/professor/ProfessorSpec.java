package br.gov.ce.sps.template.domain.spec.professor;

import br.gov.ce.sps.template.domain.filter.ProfessorFilter;
import br.gov.ce.sps.template.domain.model.Professor;
import br.gov.ce.sps.template.domain.spec.FilterSpec;
import br.gov.ce.sps.template.domain.spec.FilterStrategy;
import br.gov.ce.sps.template.domain.spec.professor.strategy.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class ProfessorSpec {

    private ProfessorSpec() {
    }

    public static Specification<Professor> usandoFiltro(ProfessorFilter filtro) {
        List<FilterStrategy<ProfessorFilter, Professor>> strategies = List.of(
                new NomeFilterStrategy(),
                new RgFilterStrategy(),
                new CpfFilterStrategy(),
                new SexoFilterStrategy(),
                new CepFilterStrategy(),
                new BairroFilterStrategy(),
                new CidadeFilterStrategy(),
                new EstadoFilterStrategy(),
                new StatusFilterStrategy(),
                new DepartamentoIdFilterStrategy()
        );
        return FilterSpec.execute(filtro, strategies);
    }

}
