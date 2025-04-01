package br.gov.ce.sps.template.api.response;

import br.gov.ce.sps.template.domain.model.enums.SexoEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ProfessorResponse {

    private Long id;

    private UUID codigo;

    private String nome;

    private Integer idade;

    private String rg;

    private String orgaoExpedidorRg;

    private String cpf;

    private SexoEnum sexo;

    private EnderecoResponse endereco;

    private ContatoResponse contato;

    private Boolean status;

    private DepartamentoResponse departamento;

    private List<DisciplinaResponse> disciplinas;

}
