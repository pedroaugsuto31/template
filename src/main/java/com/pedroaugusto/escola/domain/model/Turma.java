package com.pedroaugusto.escola.domain.model;

import com.pedroaugusto.escola.domain.model.base.EntityBase;
import com.pedroaugusto.escola.domain.model.enums.DiaEnum;
import com.pedroaugusto.escola.domain.model.enums.TurnoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "turma")
public class Turma extends EntityBase {

    @Column(name = "nome", nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "turno", nullable = false)
    private TurnoEnum turno;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = DiaEnum.class)
    @CollectionTable(name = "turma_dia")
    @Column(name = "dia", nullable = false)
    private List<DiaEnum> dias = new ArrayList<>();

    @Column(name = "quantidade_maxima", nullable = false)
    private Integer quantidadeMaxima;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    @ManyToOne
    @JoinColumn(name = "curso_id",
            foreignKey = @ForeignKey(name = "fk_turma_curso"))
    private Curso curso;

    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Turma turma = (Turma) o;
        return Objects.equals(nome, turma.nome)
                && turno == turma.turno
                && Objects.equals(dias, turma.dias)
                && Objects.equals(quantidadeMaxima, turma.quantidadeMaxima)
                && Objects.equals(dataInicio, turma.dataInicio)
                && Objects.equals(dataFim, turma.dataFim)
                && Objects.equals(curso, turma.curso)
                && Objects.equals(alunos, turma.alunos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                nome, turno, dias, quantidadeMaxima, dataInicio, dataFim, curso, alunos);
    }

}
