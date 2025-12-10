package com.pedroaugusto.escola.api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DepartamentoResponse {

    private Long id;
    private UUID codigo;
    private String nome;

}
