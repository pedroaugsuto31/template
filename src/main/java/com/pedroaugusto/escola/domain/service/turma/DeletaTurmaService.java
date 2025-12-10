package com.pedroaugusto.escola.domain.service.turma;

import com.pedroaugusto.escola.domain.model.Turma;
import com.pedroaugusto.escola.domain.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletaTurmaService {

    private final TurmaRepository turmaRepository;
    private final BuscaTurmaService buscaTurmaService;

    @Transactional
    public void deletar(UUID codigo) {
        Turma turma = buscaTurmaService.findByCode(codigo);
        turmaRepository.delete(turma);
    }

}
