package com.pedroaugusto.escola.domain.service.alunoturma;

import com.pedroaugusto.escola.domain.exception.NegocioException;
import com.pedroaugusto.escola.domain.model.Aluno;
import com.pedroaugusto.escola.domain.model.Turma;
import com.pedroaugusto.escola.domain.repository.AlunoRepository;
import com.pedroaugusto.escola.domain.service.aluno.BuscaAlunoService;
import com.pedroaugusto.escola.domain.service.turma.BuscaTurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssociaAlunosTurmaService {

    private final BuscaAlunoService buscaAlunoService;
    private final BuscaTurmaService buscaTurmaService;
    private final AlunoRepository alunoRepository;

    @Transactional
    public void associaAlunosTurma(Long turmaId, List<Long> alunosId) {
        Turma turmaById = buscaTurmaService.findById(turmaId);

        int totalAlunosAtuais = turmaById.getAlunos().size();
        int totalAlunosAdicionados = alunosId.size();

        if (totalAlunosAtuais + totalAlunosAdicionados > turmaById.getQuantidadeMaxima()) {
            throw new NegocioException("A turma não pode exceder a quantidade máxima de alunos.", new Exception());
        }

        for (Long alunoId : alunosId) {
            Aluno alunoById = buscaAlunoService.findById(alunoId);

            if (alunoById.getTurma() != null) {
                throw new NegocioException("O aluno " + alunoById.getNome() +
                        " já esta associado a Turma " + alunoById.getTurma().getNome(),
                        new Exception());
            }

            alunoById.setTurma(turmaById);
            alunoRepository.save(alunoById);
        }
    }

}
