package com.pedroaugusto.escola.domain.service.alunocurso;

import com.pedroaugusto.escola.domain.model.Aluno;
import com.pedroaugusto.escola.domain.model.Curso;
import com.pedroaugusto.escola.domain.repository.AlunoRepository;
import com.pedroaugusto.escola.domain.service.aluno.BuscaAlunoService;
import com.pedroaugusto.escola.domain.service.curso.BuscaCursoService;
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
