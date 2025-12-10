package com.pedroaugusto.escola.domain.service.curso;

import com.pedroaugusto.escola.domain.model.Curso;
import com.pedroaugusto.escola.domain.repository.CursoRepository;
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
