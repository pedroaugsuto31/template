package com.pedroaugusto.escola.domain.service.disciplina;

import com.pedroaugusto.escola.domain.filter.DisciplinaFilter;
import com.pedroaugusto.escola.domain.model.Disciplina;
import com.pedroaugusto.escola.domain.repository.DisciplinaRepository;
import com.pedroaugusto.escola.domain.spec.disciplina.DisciplinaSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListaDisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public List<Disciplina> listarTodas() {
        return disciplinaRepository.findAll();
    }

    public Page<Disciplina> listar(DisciplinaFilter disciplinaFilter, Pageable pageable) {
        return disciplinaRepository.findAll(DisciplinaSpec.usandoFiltro(disciplinaFilter), pageable);
    }

}
