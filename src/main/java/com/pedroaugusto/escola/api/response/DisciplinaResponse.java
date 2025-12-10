package com.pedroaugusto.escola.api.response;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class DisciplinaResponse {

    private Long id;

    private UUID codigo;

    private String nome;

    private Duration cargaHoraria;

    private String descricao;

    private Integer numeroAlunos;

    private DepartamentoResponse departamento;

    private List<CursoResponse> cursos;

}
