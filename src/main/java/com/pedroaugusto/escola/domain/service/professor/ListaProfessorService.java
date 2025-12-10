package com.pedroaugusto.escola.domain.service.professor;

import com.pedroaugusto.escola.domain.filter.ProfessorFilter;
import com.pedroaugusto.escola.domain.model.Professor;
import com.pedroaugusto.escola.domain.repository.ProfessorRepository;
import com.pedroaugusto.escola.domain.spec.professor.ProfessorSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListaProfessorService {

    private final ProfessorRepository professorRepository;

    public List<Professor> listarTodas() {
        return professorRepository.findAll();
    }

    public Page<Professor> listar(ProfessorFilter filtro, Pageable pageable) {
        return professorRepository.findAll(ProfessorSpec.usandoFiltro(filtro), pageable);
    }

}
