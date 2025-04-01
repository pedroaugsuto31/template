package br.gov.ce.sps.template.domain.service.disciplina;

import br.gov.ce.sps.template.domain.model.Disciplina;
import br.gov.ce.sps.template.domain.repository.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CadastroDisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    @Transactional
    public Disciplina salvar(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

}
