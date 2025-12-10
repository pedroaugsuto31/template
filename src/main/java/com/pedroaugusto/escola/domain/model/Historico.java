package com.pedroaugusto.escola.domain.model;

import com.pedroaugusto.escola.domain.model.base.EntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "historico")
public class Historico extends EntityBase {

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    @ManyToOne
    @JoinColumn(name = "aluno_id",
            foreignKey = @ForeignKey(name = "fk_historico_aluno"))
    private Aluno aluno;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Historico historico = (Historico) o;
        return Objects.equals(dataInicio, historico.dataInicio)
                && Objects.equals(dataFim, historico.dataFim)
                && Objects.equals(aluno, historico.aluno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                dataInicio, dataFim, aluno);
    }

}
