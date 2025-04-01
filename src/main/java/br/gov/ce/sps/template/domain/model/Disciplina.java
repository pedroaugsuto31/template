package br.gov.ce.sps.template.domain.model;

import br.gov.ce.sps.template.domain.model.base.EntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "disciplina")
public class Disciplina extends EntityBase {

    @Column(name = "nome")
    private String nome;

    @Column(name = "carga_horaria")
    private Duration cargaHoraria;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "numero_alunos")
    private Integer numeroAlunos;

    @ManyToOne
    @JoinColumn(name = "departamento_id",
            foreignKey = @ForeignKey(name = "fk_disciplina_departamento"))
    private Departamento departamento;

    @ManyToMany
    private List<Curso> cursos;

    @ManyToMany(mappedBy = "disciplinas")
    private List<Professor> professores;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Disciplina that = (Disciplina) o;
        return Objects.equals(nome, that.nome)
                && Objects.equals(cargaHoraria, that.cargaHoraria)
                && Objects.equals(descricao, that.descricao)
                && Objects.equals(numeroAlunos, that.numeroAlunos)
                && Objects.equals(departamento, that.departamento)
                && Objects.equals(cursos, that.cursos)
                && Objects.equals(professores, that.professores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                nome, cargaHoraria, descricao, numeroAlunos, departamento, cursos, professores);
    }

}
