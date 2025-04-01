package br.gov.ce.sps.template.domain.service.professor;

import br.gov.ce.sps.template.domain.filter.ProfessorFilter;
import br.gov.ce.sps.template.domain.model.Professor;
import br.gov.ce.sps.template.domain.repository.ProfessorRepository;
import br.gov.ce.sps.template.domain.spec.professor.ProfessorSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListaProfessorService {

    private final ProfessorRepository professorRepository;

    public List<Professor> listarTodas() {
        return professorRepository.findAll();
    }

    public Page<Professor> listar(ProfessorFilter filtro, Pageable pageable) {
        return professorRepository.findAll(ProfessorSpec.usandoFiltro(filtro), pageable);
    }

}
