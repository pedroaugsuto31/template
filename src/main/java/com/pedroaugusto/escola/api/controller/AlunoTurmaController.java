package com.pedroaugusto.escola.api.controller;

import com.pedroaugusto.escola.domain.service.alunoturma.AssociaAlunosTurmaService;
import com.pedroaugusto.escola.domain.service.alunoturma.DesassociaAlunosTurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas/{turmaId}")
@RequiredArgsConstructor
public class AlunoTurmaController {

    private final AssociaAlunosTurmaService associaAlunosTurmaService;
    private final DesassociaAlunosTurmaService desassociaAlunosTurmaService;

    @PutMapping("/associar")
    public ResponseEntity<Void> associarAlunosTurma(@PathVariable Long turmaId, @RequestBody List<Long> alunosId) {
        associaAlunosTurmaService.associaAlunosTurma(turmaId, alunosId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/desassociar")
    public ResponseEntity<Void> desassociarAlunosTurma(@PathVariable Long turmaId, @RequestBody List<Long> alunosId) {
        desassociaAlunosTurmaService.desassociaAlunosTurma(turmaId, alunosId);
        return ResponseEntity.noContent().build();
    }

}
