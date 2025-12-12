package com.pedroaugusto.escola.api.controller;

import com.pedroaugusto.escola.api.assembler.GenericAssembler;
import com.pedroaugusto.escola.api.disassembler.generic.GenericDisassembler;
import com.pedroaugusto.escola.api.request.AlunoRequest;
import com.pedroaugusto.escola.api.response.AlunoResponse;
import com.pedroaugusto.escola.api.response.list.AlunoListResponse;
import com.pedroaugusto.escola.domain.filter.AlunoFilter;
import com.pedroaugusto.escola.domain.model.Aluno;
import com.pedroaugusto.escola.domain.service.aluno.*;
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
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final ListaAlunoService listaAlunoService;
    private final BuscaAlunoService buscaAlunoService;
    private final CadastroAlunoService cadastroAlunoService;
    private final AtualizaAlunoService atualizaAlunoService;
    private final DeletaAlunoService deletaAlunoService;

    private final GenericAssembler assembler;
    private final GenericDisassembler disassembler;

    @GetMapping("/all")
    public List<AlunoListResponse> listarTodas() {
        List<Aluno> alunoList = listaAlunoService.listarTodas();

        return assembler.toCollectionResponseList(alunoList, AlunoListResponse.class);
    }

    @GetMapping
    public Page<AlunoListResponse> listar(AlunoFilter filtro, Pageable pageable) {
        Page<Aluno> alunoPage = listaAlunoService.listar(filtro, pageable);
        List<AlunoListResponse> alunoList = assembler.toCollectionResponseList(alunoPage.getContent(), AlunoListResponse.class);

        return new PageImpl<>(alunoList, alunoPage.getPageable(), alunoPage.getTotalElements());
    }

    @GetMapping("/{codigo}")
    public AlunoResponse buscar(@PathVariable UUID codigo) {
        Aluno aluno = buscaAlunoService.findByCode(codigo);

        return assembler.toResponse(aluno, AlunoResponse.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoResponse adicionar(@Valid @RequestBody AlunoRequest alunoRequest) {
        Aluno alunoResult = assembler.toEntity(alunoRequest, Aluno.class);
        Aluno alunoSalvo = cadastroAlunoService.salvar(alunoResult);

        return assembler.toResponse(alunoSalvo, AlunoResponse.class);
    }

    @PutMapping("/{codigo}")
    public AlunoResponse atualizar(@PathVariable UUID codigo, @Valid @RequestBody AlunoRequest alunoRequest) {
        Aluno aluno = buscaAlunoService.findByCode(codigo);
        disassembler.copyToEntity(alunoRequest, aluno);
        Aluno alunoAtualizado = atualizaAlunoService.atualizar(aluno);

        return assembler.toResponse(alunoAtualizado, AlunoResponse.class);
    }

    @PatchMapping("/{codigo}/editar-parcial")
    public AlunoResponse atualizarParcial(@PathVariable UUID codigo, @Valid @RequestBody AlunoRequest alunoRequest) {
        Aluno aluno = buscaAlunoService.findByCode(codigo);
        disassembler.copyToEntityPatch(alunoRequest, aluno);
        Aluno alunoAtualizado = atualizaAlunoService.atualizar(aluno);

        return assembler.toResponse(alunoAtualizado, AlunoResponse.class);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable UUID codigo) {
        deletaAlunoService.deletar(codigo);
    }

}
