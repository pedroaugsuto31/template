package br.gov.ce.sps.template.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoRequest {

    private String cep;

    private String logradouro;

    private String logradouroNumero;

    private String complemento;

    private String pontoReferencia;

    private String bairro;

    private String cidade;

    private String estado;

}
