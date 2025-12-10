package com.pedroaugusto.escola.domain.service.disciplina;

import com.pedroaugusto.escola.domain.model.Disciplina;
import com.pedroaugusto.escola.domain.repository.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletaDisciplinaService {

    private final DisciplinaRepository disciplinaRepository;
    private final BuscaDisciplinaService buscaDisciplinaService;

    public void deletar(UUID codigo) {
        Disciplina disciplina = buscaDisciplinaService.findByCode(codigo);
        disciplinaRepository.delete(disciplina);
    }

}
