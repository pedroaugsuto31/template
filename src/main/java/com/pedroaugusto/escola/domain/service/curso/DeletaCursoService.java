package com.pedroaugusto.escola.domain.service.curso;

import com.pedroaugusto.escola.domain.model.Curso;
import com.pedroaugusto.escola.domain.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletaCursoService {

    private final CursoRepository repository;
    private final BuscaCursoService service;

    @Transactional
    public void deletar(UUID codigo) {
        Curso curso = service.findByCode(codigo);
        repository.delete(curso);
    }

}
