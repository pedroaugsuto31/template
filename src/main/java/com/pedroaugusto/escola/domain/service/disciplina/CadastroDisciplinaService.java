package com.pedroaugusto.escola.domain.service.disciplina;

import com.pedroaugusto.escola.domain.model.Disciplina;
import com.pedroaugusto.escola.domain.repository.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CadastroDisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    @Transactional
    public Disciplina salvar(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

}
