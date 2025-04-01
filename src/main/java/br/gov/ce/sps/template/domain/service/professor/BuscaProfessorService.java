package br.gov.ce.sps.template.domain.service.professor;

import br.gov.ce.sps.template.domain.exception.EntidadeNaoEncontradaException;
import br.gov.ce.sps.template.domain.model.Professor;
import br.gov.ce.sps.template.domain.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscaProfessorService {

    private final ProfessorRepository professorRepository;

    public Professor findById(Long id) {
        return professorRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Professor com id " + id + " não encontrado"));
    }

    public Professor findByCode(UUID codigo) {
        return professorRepository.findByCodigo(codigo).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Professor não encontrado"));
    }

}
