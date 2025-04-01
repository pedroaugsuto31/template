package br.gov.ce.sps.template.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Endereco {

    @Column(name = "cep")
    private String cep;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "logradouro_numero")
    private String logradouroNumero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "ponto_referencia")
    private String pontoReferencia;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

}
