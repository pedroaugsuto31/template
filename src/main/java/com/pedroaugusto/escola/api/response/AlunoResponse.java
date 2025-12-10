package com.pedroaugusto.escola.api.response;

import com.pedroaugusto.escola.domain.model.enums.SexoEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class AlunoResponse {

    private Long id;

    private UUID codigo;

    private String nome;

    private LocalDateTime dataNascimento;

    private String rg;

    private String orgaoExpedidorRg;

    private String cpf;

    private SexoEnum sexo;

    private EnderecoResponse endereco;

    private ContatoResponse contato;

    private String turmaNome;

}
