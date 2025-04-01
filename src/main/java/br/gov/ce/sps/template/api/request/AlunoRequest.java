package br.gov.ce.sps.template.api.request;

import br.gov.ce.sps.template.domain.model.enums.SexoEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

@Getter
@Setter
public class AlunoRequest {

    @NotBlank
    private String nome;

    private LocalDateTime dataNascimento;

    @NotBlank
    private String rg;

    @NotBlank
    private String orgaoExpedidorRg;

    @CPF
    @NotBlank
    private String cpf;

    private SexoEnum sexo;

    private ContatoRequest contato;

    private EnderecoRequest endereco;

}
