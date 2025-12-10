package com.pedroaugusto.escola.domain.service.aluno;

import com.pedroaugusto.escola.domain.exception.EntidadeNaoEncontradaException;
import com.pedroaugusto.escola.domain.model.Aluno;
import com.pedroaugusto.escola.domain.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AtualizaAlunoService {

    private final AlunoRepository alunoRepository;

    @Transactional
    public Aluno atualizar(Aluno aluno) {
        if (aluno.getId() == null || aluno.getCodigo() == null) {
            throw new EntidadeNaoEncontradaException("Aluno não encontrado");
        }

        return alunoRepository.save(aluno);
    }

}
