package br.gov.ce.sps.template.domain.model.enums;

import lombok.Getter;

public enum DiaEnum {

    SEGUNDA("Segunda-feira"),
    TERCA("Terça-feira"),
    QUARTA("Quarta-feira"),
    QUINTA("Quinta-feira"),
    SEXTA("Sexta-feira"),
    SABADO("Sábado"),
    DOMINGO("Domingo");

    @Getter
    private final String descricao;

    DiaEnum(String descricao) {
        this.descricao = descricao;
    }

}
