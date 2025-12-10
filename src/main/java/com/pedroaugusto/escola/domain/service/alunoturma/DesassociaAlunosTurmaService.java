package com.pedroaugusto.escola.domain.service.alunoturma;

import com.pedroaugusto.escola.domain.model.Aluno;
import com.pedroaugusto.escola.domain.repository.AlunoRepository;
import com.pedroaugusto.escola.domain.service.aluno.BuscaAlunoService;
import com.pedroaugusto.escola.domain.service.turma.BuscaTurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DesassociaAlunosTurmaService {

    private final BuscaAlunoService buscaAlunoService;
    private final BuscaTurmaService buscaTurmaService;
    private final AlunoRepository alunoRepository;

    @Transactional
    public void desassociaAlunosTurma(Long turmaId, List<Long> alunosId) {
        buscaTurmaService.findById(turmaId);
        for (Long alunoId : alunosId) {
            Aluno alunoById = buscaAlunoService.findById(alunoId);
            alunoById.setTurma(null);
            alunoRepository.save(alunoById);
        }
    }

}
