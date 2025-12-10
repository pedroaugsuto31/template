package com.pedroaugusto.escola.domain.service.curso;

import com.pedroaugusto.escola.domain.exception.EntidadeNaoEncontradaException;
import com.pedroaugusto.escola.domain.model.Curso;
import com.pedroaugusto.escola.domain.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AtualizaCursoService {

    private final CursoRepository repository;

    @Transactional
    public Curso atualizar(Curso curso) {
        if (curso.getId() == null || curso.getCodigo() == null) {
            throw new EntidadeNaoEncontradaException("Não encontrado");
        }

        return repository.save(curso);
    }

}
