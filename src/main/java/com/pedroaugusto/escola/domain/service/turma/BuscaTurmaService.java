package com.pedroaugusto.escola.domain.service.turma;

import com.pedroaugusto.escola.domain.exception.EntidadeNaoEncontradaException;
import com.pedroaugusto.escola.domain.model.Turma;
import com.pedroaugusto.escola.domain.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscaTurmaService {

    private final TurmaRepository turmaRepository;

    public Turma findById(Long id) {
        return turmaRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Turma não encontrada"));
    }

    public Turma findByCode(UUID codigo) {
        return turmaRepository.findByCodigo(codigo).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Turma não encontrada"));
    }

}
