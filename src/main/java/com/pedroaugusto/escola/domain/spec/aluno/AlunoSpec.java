package com.pedroaugusto.escola.domain.spec.aluno;

import com.pedroaugusto.escola.domain.filter.AlunoFilter;
import com.pedroaugusto.escola.domain.model.Aluno;
import com.pedroaugusto.escola.domain.spec.FilterSpec;
import com.pedroaugusto.escola.domain.spec.FilterStrategy;
import com.pedroaugusto.escola.domain.spec.aluno.strategy.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class AlunoSpec {

    private AlunoSpec() {
    }

    public static Specification<Aluno> usandoFiltro(AlunoFilter filtro) {
        List<FilterStrategy<AlunoFilter, Aluno>> strategies = List.of(
                new NomeFilterStrategy(),
                new RgFilterStrategy(),
                new CpfFilterStrategy(),
                new SexoFilterStrategy(),
                new CepFilterStrategy(),
                new BairroFilterStrategy(),
                new CidadeFilterStrategy(),
                new EstadoFilterStrategy(),
                new TurmaIdFilterStrategy()
        );
        return FilterSpec.execute(filtro, strategies);
    }

}
