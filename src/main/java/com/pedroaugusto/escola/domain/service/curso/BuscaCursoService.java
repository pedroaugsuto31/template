package com.pedroaugusto.escola.domain.service.curso;

import com.pedroaugusto.escola.domain.exception.EntidadeNaoEncontradaException;
import com.pedroaugusto.escola.domain.model.Curso;
import com.pedroaugusto.escola.domain.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscaCursoService {

    private final CursoRepository repository;

    public Curso findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Não encontrado"));
    }

    public Curso findByCode(UUID codigo) {
        return repository.findByCodigo(codigo).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Não encontrado"));
    }

}
