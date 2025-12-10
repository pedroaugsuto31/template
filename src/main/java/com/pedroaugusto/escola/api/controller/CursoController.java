package com.pedroaugusto.escola.api.controller;

import com.pedroaugusto.escola.api.assembler.GenericAssembler;
import com.pedroaugusto.escola.api.disassembler.CursoDisassembler;
import com.pedroaugusto.escola.api.request.CursoRequest;
import com.pedroaugusto.escola.api.response.CursoResponse;
import com.pedroaugusto.escola.domain.model.Curso;
import com.pedroaugusto.escola.domain.service.curso.*;
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
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CadastroCursoService cadastroCursoService;
    private final BuscaCursoService buscaCursoService;
    private final ListaCursoService listaCursoService;
    private final AtualizaCursoService atualizaCursoService;
    private final DeletaCursoService deletaCursoService;

    private final GenericAssembler assembler;
    private final CursoDisassembler disassembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CursoResponse adicionar(@Valid @RequestBody CursoRequest request) {
        Curso curso = assembler.toEntity(request, Curso.class);
        Curso cursoSalvo = cadastroCursoService.salvar(curso);

        return assembler.toResponse(cursoSalvo, CursoResponse.class);
    }

    @GetMapping("/{codigo}")
    public CursoResponse buscar(@PathVariable UUID codigo) {
        Curso curso = buscaCursoService.findByCode(codigo);

        return assembler.toResponse(curso, CursoResponse.class);
    }

    @GetMapping("/all")
    public List<CursoResponse> listar() {
        List<Curso> cursoList = listaCursoService.listar();

        return assembler.toCollectionResponseList(cursoList, CursoResponse.class);
    }

    @GetMapping
    public Page<CursoResponse> listarPaginado(Pageable pageable) {
        Page<Curso> cursoPage = listaCursoService.listarPaginado(pageable);
        List<CursoResponse> cursoResponseList = assembler.toCollectionResponseList(cursoPage.getContent(), CursoResponse.class);

        return new PageImpl<>(cursoResponseList, cursoPage.getPageable(), cursoPage.getTotalElements());
    }

    @PutMapping("/{codigo}")
    public CursoResponse atualizar(@PathVariable UUID codigo, @Valid @RequestBody CursoRequest request) {
        Curso curso = buscaCursoService.findByCode(codigo);
        disassembler.copyToEntity(request, curso);
        Curso cursoAtualizado = atualizaCursoService.atualizar(curso);

        return assembler.toResponse(cursoAtualizado, CursoResponse.class);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable UUID codigo) {
        deletaCursoService.deletar(codigo);
    }

}
