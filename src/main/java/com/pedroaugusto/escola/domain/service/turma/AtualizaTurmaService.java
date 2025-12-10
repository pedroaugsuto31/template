package com.pedroaugusto.escola.domain.service.turma;

import com.pedroaugusto.escola.domain.exception.EntidadeNaoEncontradaException;
import com.pedroaugusto.escola.domain.model.Turma;
import com.pedroaugusto.escola.domain.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AtualizaTurmaService {

    private final TurmaRepository turmaRepository;

    @Transactional
    public Turma atualizar(Turma turma) {
        if (turma.getId() == null || turma.getCodigo() == null) {
            throw new EntidadeNaoEncontradaException("Turma não encontrada");
        }

        return turmaRepository.save(turma);
    }

}
