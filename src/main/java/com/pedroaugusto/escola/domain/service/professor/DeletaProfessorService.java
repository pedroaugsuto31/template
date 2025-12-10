package com.pedroaugusto.escola.domain.service.professor;

import com.pedroaugusto.escola.domain.model.Professor;
import com.pedroaugusto.escola.domain.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletaProfessorService {

    private final ProfessorRepository professorRepository;
    private final BuscaProfessorService buscaProfessorService;

    @Transactional
    public void deletar(UUID codigo) {
        Professor professor = buscaProfessorService.findByCode(codigo);
        professorRepository.delete(professor);
    }

}
