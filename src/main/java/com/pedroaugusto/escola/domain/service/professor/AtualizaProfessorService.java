package com.pedroaugusto.escola.domain.service.professor;

import com.pedroaugusto.escola.domain.exception.EntidadeNaoEncontradaException;
import com.pedroaugusto.escola.domain.model.Professor;
import com.pedroaugusto.escola.domain.repository.ProfessorRepository;
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
