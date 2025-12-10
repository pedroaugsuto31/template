package com.pedroaugusto.escola.api.controller;

import com.pedroaugusto.escola.domain.service.alunocurso.AssociaAlunoCursoService;
import com.pedroaugusto.escola.domain.service.alunocurso.DesassociaAlunoCursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turmas/{alunoId}")
@RequiredArgsConstructor
public class AlunoCursoController {

    private final AssociaAlunoCursoService associaAlunoCursoService;
    private final DesassociaAlunoCursoService desassociaAlunoCursoService;

    @PutMapping("/associar/{cursoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associarAlunoCurso(@PathVariable Long alunoId, @PathVariable Long cursoId) {
        associaAlunoCursoService.associarAlunoCurso(alunoId, cursoId);
    }

    @DeleteMapping("/desassociar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociarAlunoCurso(@PathVariable Long alunoId) {
        desassociaAlunoCursoService.desassociarAlunoCurso(alunoId);
    }

}
