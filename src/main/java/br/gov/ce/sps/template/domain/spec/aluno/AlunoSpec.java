package br.gov.ce.sps.template.domain.spec.aluno;

import br.gov.ce.sps.template.domain.filter.AlunoFilter;
import br.gov.ce.sps.template.domain.model.Aluno;
import br.gov.ce.sps.template.domain.spec.FilterSpec;
import br.gov.ce.sps.template.domain.spec.FilterStrategy;
import br.gov.ce.sps.template.domain.spec.aluno.strategy.*;
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
