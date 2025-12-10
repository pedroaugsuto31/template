package com.pedroaugusto.escola.domain.service.professor;

import com.pedroaugusto.escola.domain.exception.EntidadeNaoEncontradaException;
import com.pedroaugusto.escola.domain.model.Professor;
import com.pedroaugusto.escola.domain.repository.ProfessorRepository;
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
