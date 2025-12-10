package com.pedroaugusto.escola.api.response.list;

import com.pedroaugusto.escola.domain.model.enums.SexoEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AlunoListResponse {

    private Long id;

    private UUID codigo;

    private String primeiroNome;

    private Integer idade;

    private SexoEnum sexo;

}
