package br.gov.ce.sps.template.domain.service.alunocurso;

import br.gov.ce.sps.template.domain.model.Aluno;
import br.gov.ce.sps.template.domain.model.Curso;
import br.gov.ce.sps.template.domain.repository.AlunoRepository;
import br.gov.ce.sps.template.domain.service.aluno.BuscaAlunoService;
import br.gov.ce.sps.template.domain.service.curso.BuscaCursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssociaAlunoCursoService {

    private final BuscaAlunoService buscaAlunoService;
    private final BuscaCursoService buscaCursoService;

    private final AlunoRepository alunoRepository;

    public void associarAlunoCurso(Long alunoId, Long cursoId) {
        Aluno aluno = buscaAlunoService.findById(alunoId);
        Curso curso = buscaCursoService.findById(cursoId);

        aluno.setCurso(curso);
        alunoRepository.save(aluno);
    }

}
