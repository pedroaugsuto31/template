package br.gov.ce.sps.template.domain.service.professor;

import br.gov.ce.sps.template.domain.exception.EntidadeNaoEncontradaException;
import br.gov.ce.sps.template.domain.model.Professor;
import br.gov.ce.sps.template.domain.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AtualizaProfessorService {

    private final ProfessorRepository professorRepository;

    @Transactional
    public Professor atualizar(Professor professor) {
        if (professor.getId() == null || professor.getCodigo() == null) {
            throw new EntidadeNaoEncontradaException("Professor não encontrado");
        }

        return professorRepository.save(professor);
    }

}
