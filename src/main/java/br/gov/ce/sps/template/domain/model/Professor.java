package br.gov.ce.sps.template.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "professor")
public class Professor extends Pessoa {

    @Column(name = "status", nullable = false)
    private Boolean status = Boolean.TRUE;

    @ManyToOne(optional = false)
    @JoinColumn(name = "departamento_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_professor_departamento"))
    private Departamento departamento;

    @ManyToMany
    @JoinTable(name = "professor_disciplina",
            joinColumns = @JoinColumn(name = "professor_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_professor_disciplina_professor")),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_professor_disciplina_disciplina")))
    private List<Disciplina> disciplinas;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Professor professor = (Professor) o;
        return Objects.equals(status, professor.status)
                && Objects.equals(departamento, professor.departamento)
                && Objects.equals(disciplinas, professor.disciplinas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                status, departamento, disciplinas);
    }

}
