package com.pedroaugusto.escola.domain.service.departamento;

import com.pedroaugusto.escola.domain.model.Departamento;
import com.pedroaugusto.escola.domain.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CadastroDepartamentoService {

    private final DepartamentoRepository repository;

    @Transactional
    public Departamento salvar(Departamento departamento) {
        return repository.save(departamento);
    }

}
