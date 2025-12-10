package com.pedroaugusto.escola.api.disassembler;

import com.pedroaugusto.escola.api.request.ProfessorRequest;
import com.pedroaugusto.escola.domain.model.Departamento;
import com.pedroaugusto.escola.domain.model.Disciplina;
import com.pedroaugusto.escola.domain.model.Professor;
import com.pedroaugusto.escola.domain.repository.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProfessorDisassembler {

    private final ModelMapper modelMapper;
    private final DisciplinaRepository disciplinaRepository;

    public Professor toEntity(ProfessorRequest request) {
        // Para ser possível a inclusão da lista de ids com ModelMapper em relacionamento ManyToMany.
        Professor professor = modelMapper.map(request, Professor.class);

        List<Disciplina> disciplinaList = disciplinaRepository.findAllById(request.getDisciplinasId());
        if (request.getDisciplinasId() != null) {
            professor.setDisciplinas(disciplinaList);
        }

        return professor;
    }

    public void copyToEntity(ProfessorRequest request, Professor professor) {
        // Para evitar a exceção: "identifier of an instance of com.pedroaugusto.escola.domain.model.O was altered from X to Y".
        Optional.ofNullable(request.getDepartamentoId())
                .ifPresent(departamentoId -> professor.setDepartamento(new Departamento()));

        professor.setDisciplinas(Optional.ofNullable(request.getDisciplinasId())
                .map(disciplinas -> disciplinas.stream()
                        .map(disciplina -> new Disciplina()).toList())
                .orElse(null));


        modelMapper.map(request, professor);
    }

}
