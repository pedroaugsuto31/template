package com.pedroaugusto.escola.domain.service.turma;

import com.pedroaugusto.escola.domain.filter.TurmaFilter;
import com.pedroaugusto.escola.domain.model.Turma;
import com.pedroaugusto.escola.domain.repository.TurmaRepository;
import com.pedroaugusto.escola.domain.spec.turma.TurmaSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListaTurmaService {

    private final TurmaRepository turmaRepository;

    public List<Turma> listarTodas() {
        return turmaRepository.findAll();
    }

    public Page<Turma> listar(TurmaFilter turmaFilter, Pageable pageable) {
        return turmaRepository.findAll(TurmaSpec.usandoFiltro(turmaFilter), pageable);
    }

}
