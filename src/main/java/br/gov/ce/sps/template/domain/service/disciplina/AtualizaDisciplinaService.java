package br.gov.ce.sps.template.domain.service.disciplina;

import br.gov.ce.sps.template.domain.exception.EntidadeNaoEncontradaException;
import br.gov.ce.sps.template.domain.model.Disciplina;
import br.gov.ce.sps.template.domain.repository.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtualizaDisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public Disciplina atualizar(Disciplina disciplina) {
        if (disciplinaRepository.existsByCodigo(disciplina.getCodigo())) {
            throw new EntidadeNaoEncontradaException("Disciplina não encontrada");
        }

        return disciplinaRepository.save(disciplina);
    }

}
