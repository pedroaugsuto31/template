package br.gov.ce.sps.template.domain.service.departamento;

import br.gov.ce.sps.template.domain.model.Departamento;
import br.gov.ce.sps.template.domain.repository.DepartamentoRepository;
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
