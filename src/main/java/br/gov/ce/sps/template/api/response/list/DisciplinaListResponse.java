package br.gov.ce.sps.template.api.response.list;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.UUID;

@Getter
@Setter
public class DisciplinaListResponse {

    private Long id;

    private UUID codigo;

    private String nome;

    private Duration cargaHoraria;

    private Integer numeroAlunos;

}
