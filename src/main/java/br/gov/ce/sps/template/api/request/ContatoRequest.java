package br.gov.ce.sps.template.api.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoRequest {

    @NotBlank
    private String telefone;

    @Email
    private String email;

}
