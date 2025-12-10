package com.pedroaugusto.escola.domain.service.professor;

import com.pedroaugusto.escola.domain.exception.CpfJaCadastradoException;
import com.pedroaugusto.escola.domain.model.Professor;
import com.pedroaugusto.escola.domain.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CadastroProfessorService {

    private final ProfessorRepository professorRepository;

    @Transactional
    public Professor salvar(Professor professor) {
        if (professor.getCpf() != null && professorRepository.existsByCpf(professor.getCpf())) {
            throw new CpfJaCadastradoException("Já existe um Professor cadastrado com o CPF informado");
        }

        return professorRepository.save(professor);
    }

}
