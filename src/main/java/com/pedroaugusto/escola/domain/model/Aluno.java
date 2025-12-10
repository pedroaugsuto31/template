package com.pedroaugusto.escola.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "aluno",
        uniqueConstraints = {@UniqueConstraint(name = "unq_aluno_cpf", columnNames = {"cpf"})})
public class Aluno extends Pessoa {

    @Column(name = "status")
    private Boolean status = Boolean.TRUE;

    @ManyToOne
    @JoinColumn(name = "turma_id",
            foreignKey = @ForeignKey(name = "fk_aluno_turma"))
    private Turma turma;

    @ManyToOne
    @JoinColumn(name = "curso_id",
            foreignKey = @ForeignKey(name = "fk_aluno_curso"))
    private Curso curso;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(status, aluno.status)
                && Objects.equals(turma, aluno.turma)
                && Objects.equals(curso, aluno.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                status, turma, curso);
    }

}
