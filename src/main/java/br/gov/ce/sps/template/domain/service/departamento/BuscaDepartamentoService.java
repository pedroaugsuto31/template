package br.gov.ce.sps.template.domain.service.departamento;

import br.gov.ce.sps.template.domain.exception.EntidadeNaoEncontradaException;
import br.gov.ce.sps.template.domain.model.Departamento;
import br.gov.ce.sps.template.domain.repository.DepartamentoRepository;
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
