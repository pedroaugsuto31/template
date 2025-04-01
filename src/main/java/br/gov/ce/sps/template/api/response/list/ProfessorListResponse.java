package br.gov.ce.sps.template.api.response.list;

import br.gov.ce.sps.template.domain.model.enums.SexoEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProfessorListResponse {

    private Long id;

    private UUID codigo;

    private String nome;

    private Integer idade;

    private SexoEnum sexo;

    private Boolean status;

    private String departamentoNome;

}
