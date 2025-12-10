package com.pedroaugusto.escola.api.response;

import com.pedroaugusto.escola.domain.model.enums.DiaEnum;
import com.pedroaugusto.escola.domain.model.enums.TurnoEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class TurmaResponse {

    private Long id;

    private UUID codigo;

    private String nome;

    private Integer quantidadeMaxima;

    private List<DiaEnum> dias;

    private TurnoEnum turno;

    private List<String> nomesAlunos;

}
