package com.pedroaugusto.escola.domain.service.turma;

import com.pedroaugusto.escola.domain.model.Turma;
import com.pedroaugusto.escola.domain.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CadastroTurmaService {

    private final TurmaRepository turmaRepository;

    @Transactional
    public Turma salvar(Turma turma) {
        return turmaRepository.save(turma);
    }

}
