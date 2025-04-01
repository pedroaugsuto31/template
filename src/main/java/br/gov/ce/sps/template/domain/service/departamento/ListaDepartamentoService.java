package br.gov.ce.sps.template.domain.service.departamento;

import br.gov.ce.sps.template.domain.model.Departamento;
import br.gov.ce.sps.template.domain.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListaDepartamentoService {

    private final DepartamentoRepository repository;

    public List<Departamento> listar() {
        return repository.findAll();
    }

    public Page<Departamento> listarPaginado(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
