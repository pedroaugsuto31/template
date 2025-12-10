package com.pedroaugusto.escola.domain.spec.professor;

import com.pedroaugusto.escola.domain.filter.ProfessorFilter;
import com.pedroaugusto.escola.domain.model.Professor;
import com.pedroaugusto.escola.domain.spec.FilterSpec;
import com.pedroaugusto.escola.domain.spec.FilterStrategy;
import com.pedroaugusto.escola.domain.spec.professor.strategy.*;
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
