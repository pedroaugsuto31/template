package com.pedroaugusto.escola.api.request;

import com.pedroaugusto.escola.domain.model.enums.DiaEnum;
import com.pedroaugusto.escola.domain.model.enums.TurnoEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TurmaRequest {

    @NotBlank
    private String nome;

    private Integer quantidadeMaxima;

    private List<DiaEnum> dias;

    private TurnoEnum turno;

}
