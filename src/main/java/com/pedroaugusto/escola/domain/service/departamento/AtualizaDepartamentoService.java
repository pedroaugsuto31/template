package com.pedroaugusto.escola.domain.service.departamento;

import com.pedroaugusto.escola.domain.exception.EntidadeNaoEncontradaException;
import com.pedroaugusto.escola.domain.model.Departamento;
import com.pedroaugusto.escola.domain.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AtualizaDepartamentoService {

    private final DepartamentoRepository repository;

    @Transactional
    public Departamento atualizar(Departamento departamento) {
        if (departamento.getId() == null || departamento.getCodigo() == null) {
            throw new EntidadeNaoEncontradaException("Não encontrado");
        }

        return repository.save(departamento);
    }

}
