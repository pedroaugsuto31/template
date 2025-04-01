package br.gov.ce.sps.template.domain.service.curso;

import br.gov.ce.sps.template.domain.exception.EntidadeNaoEncontradaException;
import br.gov.ce.sps.template.domain.model.Curso;
import br.gov.ce.sps.template.domain.repository.CursoRepository;
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
