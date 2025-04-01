package br.gov.ce.sps.template.api.request;

import br.gov.ce.sps.template.domain.model.enums.SexoEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProfessorRequest {

    private String nome;

    private LocalDateTime dataNascimento;

    private String rg;

    private String orgaoExpedidorRg;

    private String cpf;

    private SexoEnum sexo;

    private EnderecoRequest endereco;

    private ContatoRequest contato;

    private Long departamentoId;

    private List<Long> disciplinasId;

}
