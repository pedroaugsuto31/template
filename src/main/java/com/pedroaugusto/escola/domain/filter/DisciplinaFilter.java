package com.pedroaugusto.escola.domain.filter;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
public class DisciplinaFilter {

    private String nome;

    private Duration cargaHoraria;

    private String descricao;

    private Integer numeroAlunos;

}
