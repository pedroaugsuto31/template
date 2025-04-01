package br.gov.ce.sps.template.api.response;

import br.gov.ce.sps.template.domain.model.enums.DiaEnum;
import br.gov.ce.sps.template.domain.model.enums.TurnoEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class TurmaResponse {

    private Long id;

    private UUID codigo;

    private String nome;

    private Integer quantidadeMaxima;

    private List<DiaEnum> dias;

    private TurnoEnum turno;

    private List<String> nomesAlunos;

}
