package com.pedroaugusto.escola.domain.service.departamento;

import com.pedroaugusto.escola.domain.model.Departamento;
import com.pedroaugusto.escola.domain.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletaDepartamentoService {

    private final DepartamentoRepository repository;
    private final BuscaDepartamentoService service;

    @Transactional
    public void deletar(UUID codigo) {
        Departamento departamento = service.findByCode(codigo);
        repository.delete(departamento);
    }

}
