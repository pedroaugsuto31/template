package br.gov.ce.sps.template.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoResponse {

    private String cep;

    private String logradouro;

    private String logradouroNumero;

    private String complemento;

    private String bairro;

    private String pontoReferencia;

    private String cidade;

    private String estado;

}
