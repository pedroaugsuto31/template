package br.gov.ce.sps.template.domain.service.disciplina;

import br.gov.ce.sps.template.domain.model.Disciplina;
import br.gov.ce.sps.template.domain.repository.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletaDisciplinaService {

    private final DisciplinaRepository disciplinaRepository;
    private final BuscaDisciplinaService buscaDisciplinaService;

    public void deletar(UUID codigo) {
        Disciplina disciplina = buscaDisciplinaService.findByCode(codigo);
        disciplinaRepository.delete(disciplina);
    }

}
