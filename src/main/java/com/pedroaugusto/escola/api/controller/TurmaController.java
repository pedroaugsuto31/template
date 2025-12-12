package com.pedroaugusto.escola.api.controller;

import com.pedroaugusto.escola.api.assembler.GenericAssembler;
import com.pedroaugusto.escola.api.disassembler.generic.GenericDisassembler;
import com.pedroaugusto.escola.api.request.TurmaRequest;
import com.pedroaugusto.escola.api.response.TurmaResponse;
import com.pedroaugusto.escola.domain.filter.TurmaFilter;
import com.pedroaugusto.escola.domain.model.Turma;
import com.pedroaugusto.escola.domain.service.turma.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/turmas")
@RequiredArgsConstructor
public class TurmaController {

    private final ListaTurmaService listaTurmaService;
    private final BuscaTurmaService buscaTurmaService;
    private final CadastroTurmaService cadastroTurmaService;
    private final AtualizaTurmaService atualizaTurmaService;
    private final DeletaTurmaService deletaTurmaService;

    private final GenericAssembler assembler;
    private final GenericDisassembler disassembler;

    @GetMapping("/all")
    public List<TurmaResponse> listarTodas() {
        List<Turma> genericList = listaTurmaService.listarTodas();

        return assembler.toCollectionResponseList(genericList, TurmaResponse.class);
    }

    @GetMapping
    public Page<TurmaResponse> listar(TurmaFilter turmaFilter, Pageable pageable) {
        Page<Turma> turmaPage = listaTurmaService.listar(turmaFilter, pageable);
        List<TurmaResponse> turmaList = assembler.toCollectionResponseList(turmaPage.getContent(), TurmaResponse.class);

        return new PageImpl<>(turmaList, turmaPage.getPageable(), turmaPage.getTotalElements());
    }

    @GetMapping("/{codigo}")
    public TurmaResponse buscar(@PathVariable UUID codigo) {
        Turma turma = buscaTurmaService.findByCode(codigo);

        return assembler.toResponse(turma, TurmaResponse.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TurmaResponse adicionar(@Valid @RequestBody TurmaRequest turmaRequest) {
        Turma turmaResult = assembler.toEntity(turmaRequest, Turma.class);
        Turma turmaSalva = cadastroTurmaService.salvar(turmaResult);

        return assembler.toResponse(turmaSalva, TurmaResponse.class);
    }

    @PutMapping("/{codigo}")
    public TurmaResponse atualizar(@PathVariable UUID codigo, @Valid @RequestBody TurmaRequest turmaRequest) {
        Turma turmaAtual = buscaTurmaService.findByCode(codigo);
        disassembler.copyToEntity(turmaRequest, turmaAtual);

        return assembler.toResponse(atualizaTurmaService.atualizar(turmaAtual), TurmaResponse.class);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable UUID codigo) {
        deletaTurmaService.deletar(codigo);
    }

}
