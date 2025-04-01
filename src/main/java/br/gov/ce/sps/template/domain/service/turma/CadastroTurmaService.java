package br.gov.ce.sps.template.domain.service.turma;

import br.gov.ce.sps.template.domain.model.Turma;
import br.gov.ce.sps.template.domain.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CadastroTurmaService {

    private final TurmaRepository turmaRepository;

    @Transactional
    public Turma salvar(Turma turma) {
        return turmaRepository.save(turma);
    }

}
