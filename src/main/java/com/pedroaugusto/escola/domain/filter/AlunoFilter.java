package com.pedroaugusto.escola.domain.filter;

import com.pedroaugusto.escola.domain.model.enums.SexoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoFilter {

    private String nome;

    private String rg;

    private String cpf;

    private SexoEnum sexo;

    private String cep;

    private String bairro;

    private String cidade;

    private String estado;

    private Long turmaId;

}
