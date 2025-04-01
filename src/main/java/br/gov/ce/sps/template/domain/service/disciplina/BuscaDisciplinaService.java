package br.gov.ce.sps.template.domain.service.disciplina;

import br.gov.ce.sps.template.domain.exception.EntidadeNaoEncontradaException;
import br.gov.ce.sps.template.domain.model.Disciplina;
import br.gov.ce.sps.template.domain.repository.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuscaDisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public Disciplina findById(Long id) {
        return disciplinaRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Não encontrado Disciplina com o ID " + id));
    }

    public Disciplina findByCode(UUID codigo) {
        return disciplinaRepository.findByCodigo(codigo).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Não encontrado Disciplina com o codigo " + codigo));
    }

}
