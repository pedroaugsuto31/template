package br.gov.ce.sps.template.domain.service.professor;

import br.gov.ce.sps.template.domain.model.Professor;
import br.gov.ce.sps.template.domain.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletaProfessorService {

    private final ProfessorRepository professorRepository;
    private final BuscaProfessorService buscaProfessorService;

    @Transactional
    public void deletar(UUID codigo) {
        Professor professor = buscaProfessorService.findByCode(codigo);
        professorRepository.delete(professor);
    }

}
