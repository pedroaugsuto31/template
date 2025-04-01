package br.gov.ce.sps.template.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoRequest {

    private String nome;

    private Long departamentoId;

}
