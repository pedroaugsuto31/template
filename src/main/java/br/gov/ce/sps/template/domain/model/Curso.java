package br.gov.ce.sps.template.domain.model;

import br.gov.ce.sps.template.domain.model.base.EntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "curso")
public class Curso extends EntityBase {

    @Column(name = "nome", nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "departamento_id",
            foreignKey = @ForeignKey(name = "fk_curso_departamento"))
    private Departamento departamento;

    @ManyToMany
    @JoinTable(name = "curso_disciplina",
            joinColumns = @JoinColumn(name = "curso_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_curso_disciplina_curso")),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_curso_disciplina_disciplina")))
    private List<Disciplina> disciplinas;

    @OneToMany(mappedBy = "curso")
    private List<Turma> turmas;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Curso curso = (Curso) o;
        return Objects.equals(nome, curso.nome)
                && Objects.equals(departamento, curso.departamento)
                && Objects.equals(disciplinas, curso.disciplinas)
                && Objects.equals(turmas, curso.turmas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                nome, departamento, disciplinas, turmas);
    }

}
