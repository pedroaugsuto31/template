package br.gov.ce.sps.template.domain.service.turma;

import br.gov.ce.sps.template.domain.filter.TurmaFilter;
import br.gov.ce.sps.template.domain.model.Turma;
import br.gov.ce.sps.template.domain.repository.TurmaRepository;
import br.gov.ce.sps.template.domain.spec.turma.TurmaSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListaTurmaService {

    private final TurmaRepository turmaRepository;

    public List<Turma> listarTodas() {
        return turmaRepository.findAll();
    }

    public Page<Turma> listar(TurmaFilter turmaFilter, Pageable pageable) {
        return turmaRepository.findAll(TurmaSpec.usandoFiltro(turmaFilter), pageable);
    }

}
