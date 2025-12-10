package com.pedroaugusto.escola.domain.service.curso;

import com.pedroaugusto.escola.domain.model.Curso;
import com.pedroaugusto.escola.domain.repository.CursoRepository;
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
