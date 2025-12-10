package com.pedroaugusto.escola.api.controller;

import com.pedroaugusto.escola.api.assembler.GenericAssembler;
import com.pedroaugusto.escola.api.disassembler.generic.GenericDisassembler;
import com.pedroaugusto.escola.api.request.DepartamentoRequest;
import com.pedroaugusto.escola.api.response.DepartamentoResponse;
import com.pedroaugusto.escola.domain.model.Departamento;
import com.pedroaugusto.escola.domain.service.departamento.*;
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
@RequestMapping("/departamentos")
@RequiredArgsConstructor
public class DepartamentoController {

    private final CadastroDepartamentoService cadastroDepartamentoService;
    private final BuscaDepartamentoService buscaDepartamentoService;
    private final ListaDepartamentoService listaDepartamentoService;
    private final AtualizaDepartamentoService atualizaDepartamentoService;
    private final DeletaDepartamentoService deletaDepartamentoService;

    private final GenericAssembler assembler;
    private final GenericDisassembler disassembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartamentoResponse adicionar(@Valid @RequestBody DepartamentoRequest request) {
        Departamento departamento = assembler.toEntity(request, Departamento.class);
        Departamento departamentoSalvo = cadastroDepartamentoService.salvar(departamento);

        return assembler.toResponse(departamentoSalvo, DepartamentoResponse.class);
    }

    @GetMapping("/{codigo}")
    public DepartamentoResponse buscar(@PathVariable UUID codigo) {
        Departamento departamento = buscaDepartamentoService.findByCode(codigo);

        return assembler.toResponse(departamento, DepartamentoResponse.class);
    }

    @GetMapping("/all")
    public List<DepartamentoResponse> listar() {
        List<Departamento> departamentoList = listaDepartamentoService.listar();

        return assembler.toCollectionResponseList(departamentoList, DepartamentoResponse.class);
    }

    @GetMapping
    public Page<DepartamentoResponse> listarPaginado(Pageable pageable) {
        Page<Departamento> departamentoPage = listaDepartamentoService.listarPaginado(pageable);
        List<DepartamentoResponse> departamentoResponseList = assembler.toCollectionResponseList(departamentoPage.getContent(), DepartamentoResponse.class);

        return new PageImpl<>(departamentoResponseList, departamentoPage.getPageable(), departamentoPage.getTotalElements());
    }

    @PutMapping("/{codigo}")
    public DepartamentoResponse atualizar(@PathVariable UUID codigo, @Valid @RequestBody DepartamentoRequest request) {
        Departamento departamento = buscaDepartamentoService.findByCode(codigo);
        disassembler.copyToEntity(request, departamento);
        Departamento departamentoAtualizado = atualizaDepartamentoService.atualizar(departamento);

        return assembler.toResponse(departamentoAtualizado, DepartamentoResponse.class);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable UUID codigo) {
        deletaDepartamentoService.deletar(codigo);
    }

}
