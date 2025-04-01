package br.gov.ce.sps.template.domain.service.disciplina;

import br.gov.ce.sps.template.domain.filter.DisciplinaFilter;
import br.gov.ce.sps.template.domain.model.Disciplina;
import br.gov.ce.sps.template.domain.repository.DisciplinaRepository;
import br.gov.ce.sps.template.domain.spec.disciplina.DisciplinaSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListaDisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public List<Disciplina> listarTodas() {
        return disciplinaRepository.findAll();
    }

    public Page<Disciplina> listar(DisciplinaFilter disciplinaFilter, Pageable pageable) {
        return disciplinaRepository.findAll(DisciplinaSpec.usandoFiltro(disciplinaFilter), pageable);
    }

}
