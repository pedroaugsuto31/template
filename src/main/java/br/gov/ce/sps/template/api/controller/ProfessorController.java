package br.gov.ce.sps.template.api.controller;

import br.gov.ce.sps.template.api.assembler.GenericAssembler;
import br.gov.ce.sps.template.api.disassembler.ProfessorDisassembler;
import br.gov.ce.sps.template.api.request.ProfessorRequest;
import br.gov.ce.sps.template.api.response.ProfessorResponse;
import br.gov.ce.sps.template.api.response.list.ProfessorListResponse;
import br.gov.ce.sps.template.domain.filter.ProfessorFilter;
import br.gov.ce.sps.template.domain.model.Professor;
import br.gov.ce.sps.template.domain.service.professor.*;
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
@RequestMapping("/professores")
@RequiredArgsConstructor
public class ProfessorController {

    private final ListaProfessorService listaProfessorService;
    private final BuscaProfessorService buscaProfessorService;
    private final CadastroProfessorService cadastroProfessorService;
    private final AtualizaProfessorService atualizaProfessorService;
    private final DeletaProfessorService deletaProfessorService;

    private final GenericAssembler assembler;
    private final ProfessorDisassembler disassembler;

    @GetMapping("/all")
    public List<ProfessorListResponse> listarTodas() {
        List<Professor> professorList = listaProfessorService.listarTodas();

        return assembler.toCollectionResponseList(professorList, ProfessorListResponse.class);
    }

    @GetMapping
    public Page<ProfessorListResponse> listar(ProfessorFilter filtro, Pageable pageable) {
        Page<Professor> professorPage = listaProfessorService.listar(filtro, pageable);
        List<ProfessorListResponse> professorList = assembler.toCollectionResponseList(professorPage.getContent(), ProfessorListResponse.class);

        return new PageImpl<>(professorList, professorPage.getPageable(), professorPage.getTotalElements());
    }

    @GetMapping("/{codigo}")
    public ProfessorResponse buscar(@PathVariable UUID codigo) {
        Professor professor = buscaProfessorService.findByCode(codigo);

        return assembler.toResponse(professor, ProfessorResponse.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorResponse adicionar(@Valid @RequestBody ProfessorRequest request) {
        Professor professorResult = disassembler.toEntity(request);
        Professor professorSalvo = cadastroProfessorService.salvar(professorResult);

        return assembler.toResponse(professorSalvo, ProfessorResponse.class);
    }

    @PutMapping("/{codigo}")
    public ProfessorResponse atualizar(@PathVariable UUID codigo, @Valid @RequestBody ProfessorRequest request) {
        Professor professor = buscaProfessorService.findByCode(codigo);
        disassembler.copyToEntity(request, professor);
        Professor professorAtualizado = atualizaProfessorService.atualizar(professor);

        return assembler.toResponse(professorAtualizado, ProfessorResponse.class);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable UUID codigo) {
        deletaProfessorService.deletar(codigo);
    }

}
