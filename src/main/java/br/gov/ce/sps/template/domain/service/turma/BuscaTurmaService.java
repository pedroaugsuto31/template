package br.gov.ce.sps.template.domain.service.turma;

import br.gov.ce.sps.template.domain.exception.EntidadeNaoEncontradaException;
import br.gov.ce.sps.template.domain.model.Turma;
import br.gov.ce.sps.template.domain.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscaTurmaService {

    private final TurmaRepository turmaRepository;

    public Turma findById(Long id) {
        return turmaRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Turma não encontrada"));
    }

    public Turma findByCode(UUID codigo) {
        return turmaRepository.findByCodigo(codigo).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Turma não encontrada"));
    }

}
