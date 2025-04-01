package br.gov.ce.sps.template.domain.service.departamento;

import br.gov.ce.sps.template.domain.exception.EntidadeNaoEncontradaException;
import br.gov.ce.sps.template.domain.model.Departamento;
import br.gov.ce.sps.template.domain.repository.DepartamentoRepository;
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
