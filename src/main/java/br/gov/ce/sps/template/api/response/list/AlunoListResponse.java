package br.gov.ce.sps.template.api.response.list;

import br.gov.ce.sps.template.domain.model.enums.SexoEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AlunoListResponse {

    private Long id;

    private UUID codigo;

    private String primeiroNome;

    private Integer idade;

    private SexoEnum sexo;

}
