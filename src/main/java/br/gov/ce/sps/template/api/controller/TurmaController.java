package br.gov.ce.sps.template.api.controller;

import br.gov.ce.sps.template.api.assembler.GenericAssembler;
import br.gov.ce.sps.template.api.disassembler.generic.GenericDisassembler;
import br.gov.ce.sps.template.api.request.TurmaRequest;
import br.gov.ce.sps.template.api.response.TurmaResponse;
import br.gov.ce.sps.template.domain.filter.TurmaFilter;
import br.gov.ce.sps.template.domain.model.Turma;
import br.gov.ce.sps.template.domain.service.turma.*;
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

    private final GenericAssembler genericAssembler;
    private final GenericDisassembler genericDisassembler;

    @GetMapping("/all")
    public List<TurmaResponse> listarTodas() {
        List<Turma> genericList = listaTurmaService.listarTodas();

        return genericAssembler.toCollectionResponseList(genericList, TurmaResponse.class);
    }

    @GetMapping
    public Page<TurmaResponse> listar(TurmaFilter turmaFilter, Pageable pageable) {
        Page<Turma> turmaPage = listaTurmaService.listar(turmaFilter, pageable);
        List<TurmaResponse> turmaList = genericAssembler.toCollectionResponseList(turmaPage.getContent(), TurmaResponse.class);

        return new PageImpl<>(turmaList, turmaPage.getPageable(), turmaPage.getTotalElements());
    }

    @GetMapping("/{codigo}")
    public TurmaResponse buscar(@PathVariable UUID codigo) {
        Turma turma = buscaTurmaService.findByCode(codigo);

        return genericAssembler.toResponse(turma, TurmaResponse.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TurmaResponse adicionar(@Valid @RequestBody TurmaRequest turmaRequest) {
        Turma turmaResult = genericAssembler.toEntity(turmaRequest, Turma.class);
        Turma turmaSalva = cadastroTurmaService.salvar(turmaResult);

        return genericAssembler.toResponse(turmaSalva, TurmaResponse.class);
    }

    @PutMapping("/{codigo}")
    public TurmaResponse atualizar(@PathVariable UUID codigo, @Valid @RequestBody TurmaRequest turmaRequest) {
        Turma turmaAtual = buscaTurmaService.findByCode(codigo);
        genericDisassembler.copyToEntity(turmaRequest, turmaAtual);

        return genericAssembler.toResponse(atualizaTurmaService.atualizar(turmaAtual), TurmaResponse.class);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable UUID codigo) {
        deletaTurmaService.deletar(codigo);
    }

}
