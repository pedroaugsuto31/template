package br.gov.ce.sps.template.domain.model.enums;

import lombok.Getter;

public enum TurnoEnum {

    MANHA("Manhã"),
    TARDE("Tarde"),
    NOITE("Noite");

    @Getter
    private final String descricao;

    TurnoEnum(String descricao) {
        this.descricao = descricao;
    }

}
