package br.gov.ce.sps.template.domain.service.turma;

import br.gov.ce.sps.template.domain.exception.EntidadeNaoEncontradaException;
import br.gov.ce.sps.template.domain.model.Turma;
import br.gov.ce.sps.template.domain.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AtualizaTurmaService {

    private final TurmaRepository turmaRepository;

    @Transactional
    public Turma atualizar(Turma turma) {
        if (turma.getId() == null || turma.getCodigo() == null) {
            throw new EntidadeNaoEncontradaException("Turma não encontrada");
        }

        return turmaRepository.save(turma);
    }

}
