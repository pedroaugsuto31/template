package br.gov.ce.sps.template.domain.service.curso;

import br.gov.ce.sps.template.domain.exception.EntidadeNaoEncontradaException;
import br.gov.ce.sps.template.domain.model.Curso;
import br.gov.ce.sps.template.domain.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AtualizaCursoService {

    private final CursoRepository repository;

    @Transactional
    public Curso atualizar(Curso curso) {
        if (curso.getId() == null || curso.getCodigo() == null) {
            throw new EntidadeNaoEncontradaException("Não encontrado");
        }

        return repository.save(curso);
    }

}
