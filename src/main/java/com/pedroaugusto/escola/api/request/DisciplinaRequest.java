package com.pedroaugusto.escola.api.request;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
public class DisciplinaRequest {

    private String nome;

    private Duration cargaHoraria;

    private String descricao;

    private Integer numeroAlunos;

}
