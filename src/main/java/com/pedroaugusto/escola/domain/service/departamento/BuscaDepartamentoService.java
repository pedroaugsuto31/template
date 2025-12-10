package com.pedroaugusto.escola.domain.service.departamento;

import com.pedroaugusto.escola.domain.exception.EntidadeNaoEncontradaException;
import com.pedroaugusto.escola.domain.model.Departamento;
import com.pedroaugusto.escola.domain.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscaDepartamentoService {

    private final DepartamentoRepository repository;

    public Departamento findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Não encontrado"));
    }

    public Departamento findByCode(UUID codigo) {
        return repository.findByCodigo(codigo).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Não encontrado"));
    }

}
