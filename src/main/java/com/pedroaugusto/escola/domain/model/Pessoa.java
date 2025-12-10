package com.pedroaugusto.escola.domain.model;

import com.pedroaugusto.escola.domain.model.base.EntityBase;
import com.pedroaugusto.escola.domain.model.enums.SexoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Objects;

@Getter
@Setter
@MappedSuperclass
public class Pessoa extends EntityBase {

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDateTime dataNascimento;

    @Column(name = "rg", nullable = false)
    private String rg;

    @Column(name = "orgao_expedidor_rg", nullable = false)
    private String orgaoExpedidorRg;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private SexoEnum sexo;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Contato contato;

    @Transient
    private Integer idade;

    @Transient
    private String primeiroNome;

    @PostLoad
    private void calcularCamposTransientes() {
        if (dataNascimento != null) {
            this.idade = Period.between(this.dataNascimento.toLocalDate(), LocalDate.now()).getYears();
        }

        if (nome != null && !nome.isBlank()) {
            this.primeiroNome = nome.split(" ")[0];
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome)
                && Objects.equals(dataNascimento, pessoa.dataNascimento)
                && Objects.equals(rg, pessoa.rg)
                && Objects.equals(orgaoExpedidorRg, pessoa.orgaoExpedidorRg)
                && Objects.equals(cpf, pessoa.cpf)
                && sexo == pessoa.sexo
                && Objects.equals(endereco, pessoa.endereco)
                && Objects.equals(contato, pessoa.contato)
                && Objects.equals(idade, pessoa.idade)
                && Objects.equals(primeiroNome, pessoa.primeiroNome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                nome, dataNascimento, rg, orgaoExpedidorRg, cpf, sexo, endereco, contato, idade, primeiroNome);
    }

}
