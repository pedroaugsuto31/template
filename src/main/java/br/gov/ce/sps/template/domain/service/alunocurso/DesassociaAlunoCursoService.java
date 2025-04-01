package br.gov.ce.sps.template.domain.service.alunocurso;

import br.gov.ce.sps.template.domain.model.Aluno;
import br.gov.ce.sps.template.domain.repository.AlunoRepository;
import br.gov.ce.sps.template.domain.service.aluno.BuscaAlunoService;
import br.gov.ce.sps.template.domain.service.curso.BuscaCursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DesassociaAlunoCursoService {

    private final BuscaAlunoService buscaAlunoService;
    private final BuscaCursoService buscaCursoService;

    private final AlunoRepository alunoRepository;

    public void desassociarAlunoCurso(Long alunoId) {
        Aluno aluno = buscaAlunoService.findById(alunoId);

        aluno.setCurso(null);
        alunoRepository.save(aluno);

    }

}
