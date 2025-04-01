package br.gov.ce.sps.template.api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CursoResponse {

    private Long id;
    private UUID codigo;
    private String nome;
    private DepartamentoResponse departamento;

}
