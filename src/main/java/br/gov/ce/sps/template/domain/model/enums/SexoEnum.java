package br.gov.ce.sps.template.domain.model.enums;

import lombok.Getter;

public enum SexoEnum {

    NAO_INFORMADO("Não Informado"),
    INDEFINIDO("Indefinido"),
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    OUTROS("Outros");

    @Getter
    private final String descricao;

    SexoEnum(String descricao) {
        this.descricao = descricao;
    }

}
