package com.pedroaugusto.escola.domain.service.disciplina;

import com.pedroaugusto.escola.domain.exception.EntidadeNaoEncontradaException;
import com.pedroaugusto.escola.domain.model.Disciplina;
import com.pedroaugusto.escola.domain.repository.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtualizaDisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public Disciplina atualizar(Disciplina disciplina) {
        if (disciplinaRepository.existsByCodigo(disciplina.getCodigo())) {
            throw new EntidadeNaoEncontradaException("Disciplina não encontrada");
        }

        return disciplinaRepository.save(disciplina);
    }

}
