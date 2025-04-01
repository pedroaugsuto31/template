package br.gov.ce.sps.template.domain.service.alunoturma;

import br.gov.ce.sps.template.domain.exception.NegocioException;
import br.gov.ce.sps.template.domain.model.Aluno;
import br.gov.ce.sps.template.domain.model.Turma;
import br.gov.ce.sps.template.domain.repository.AlunoRepository;
import br.gov.ce.sps.template.domain.service.aluno.BuscaAlunoService;
import br.gov.ce.sps.template.domain.service.turma.BuscaTurmaService;
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
