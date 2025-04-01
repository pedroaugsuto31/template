package br.gov.ce.sps.template.api.controller;

import br.gov.ce.sps.template.api.assembler.GenericAssembler;
import br.gov.ce.sps.template.api.disassembler.generic.GenericDisassembler;
import br.gov.ce.sps.template.api.request.DisciplinaRequest;
import br.gov.ce.sps.template.api.response.DisciplinaResponse;
import br.gov.ce.sps.template.api.response.list.DisciplinaListResponse;
import br.gov.ce.sps.template.domain.filter.DisciplinaFilter;
import br.gov.ce.sps.template.domain.model.Disciplina;
import br.gov.ce.sps.template.domain.service.disciplina.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/disciplinas")
@RequiredArgsConstructor
public class DisciplinaController {

    private final ListaDisciplinaService listaDisciplinaService;
    private final BuscaDisciplinaService buscaDisciplinaService;
    private final CadastroDisciplinaService cadastroDisciplinaService;
    private final AtualizaDisciplinaService atualizaDisciplinaService;
    private final DeletaDisciplinaService deletaDisciplinaService;

    private final GenericAssembler assembler;
    private final GenericDisassembler disassembler;

    @GetMapping("/todos")
    public List<DisciplinaListResponse> listarTodos() {
        List<Disciplina> disciplinaList = listaDisciplinaService.listarTodas();

        return assembler.toCollectionResponseList(disciplinaList, DisciplinaListResponse.class);
    }

    @GetMapping
    public Page<DisciplinaListResponse> listar(DisciplinaFilter filter, Pageable pageable) {
        Page<Disciplina> disciplinaPage = listaDisciplinaService.listar(filter, pageable);
        List<DisciplinaListResponse> disciplinaList = assembler.toCollectionResponseList(disciplinaPage.getContent(), DisciplinaListResponse.class);

        return new PageImpl<>(disciplinaList, pageable, disciplinaList.size());
    }

    @GetMapping("/{codigo}")
    public DisciplinaResponse buscar(@PathVariable UUID codigo) {
        Disciplina disciplina = buscaDisciplinaService.findByCode(codigo);

        return assembler.toResponse(disciplina, DisciplinaResponse.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DisciplinaResponse adicionar(@RequestBody DisciplinaRequest request) {
        Disciplina disciplina = assembler.toEntity(request, Disciplina.class);
        Disciplina disciplinaSalvo = cadastroDisciplinaService.salvar(disciplina);

        return assembler.toResponse(disciplinaSalvo, DisciplinaResponse.class);
    }

    @PutMapping("/{codigo}")
    public DisciplinaResponse atualizar(@PathVariable UUID codigo, @RequestBody DisciplinaRequest request) {
        Disciplina disciplina = buscaDisciplinaService.findByCode(codigo);
        disassembler.copyToEntity(disciplina, request);

        return assembler.toResponse(atualizaDisciplinaService.atualizar(disciplina), DisciplinaResponse.class);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable UUID codigo) {
        deletaDisciplinaService.deletar(codigo);
    }

}
