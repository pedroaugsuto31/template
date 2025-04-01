package br.gov.ce.sps.template.api.request;

import br.gov.ce.sps.template.domain.model.enums.DiaEnum;
import br.gov.ce.sps.template.domain.model.enums.TurnoEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TurmaRequest {

    @NotBlank
    private String nome;

    private Integer quantidadeMaxima;

    private List<DiaEnum> dias;

    private TurnoEnum turno;

}
