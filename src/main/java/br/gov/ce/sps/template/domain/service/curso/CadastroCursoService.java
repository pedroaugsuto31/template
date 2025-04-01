package br.gov.ce.sps.template.domain.service.curso;

import br.gov.ce.sps.template.domain.model.Curso;
import br.gov.ce.sps.template.domain.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CadastroCursoService {

    private final CursoRepository repository;

    @Transactional
    public Curso salvar(Curso curso) {
        return repository.save(curso);
    }

}
