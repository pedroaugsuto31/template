package br.gov.ce.sps.template.domain.filter;

import br.gov.ce.sps.template.domain.model.enums.DiaEnum;
import br.gov.ce.sps.template.domain.model.enums.TurnoEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TurmaFilter {

    private String nome;
    private Integer quantidadeMaxima;
    private List<DiaEnum> dias;
    private TurnoEnum turno;

}
