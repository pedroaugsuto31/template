package br.gov.ce.sps.template.domain.filter;

import br.gov.ce.sps.template.domain.model.enums.SexoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorFilter {

    private String nome;

    private String rg;

    private String cpf;

    private SexoEnum sexo;

    private String cep;

    private String bairro;

    private String cidade;

    private String estado;

    private Boolean status;

    private Long departamentoId;

}
