package br.gov.ce.sps.template.domain.service.curso;

import br.gov.ce.sps.template.domain.model.Curso;
import br.gov.ce.sps.template.domain.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListaCursoService {

    private final CursoRepository repository;

    public List<Curso> listar() {
        return repository.findAll();
    }

    public Page<Curso> listarPaginado(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
