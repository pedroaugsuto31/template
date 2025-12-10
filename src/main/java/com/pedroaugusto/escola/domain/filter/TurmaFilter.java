package com.pedroaugusto.escola.domain.filter;

import com.pedroaugusto.escola.domain.model.enums.DiaEnum;
import com.pedroaugusto.escola.domain.model.enums.TurnoEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TurmaFilter {

    private String nome;
    private Integer quantidadeMaxima;
    private List<DiaEnum> dias;
    private TurnoEnum turno;

}
