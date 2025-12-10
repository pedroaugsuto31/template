package com.pedroaugusto.escola.domain.model;

import com.pedroaugusto.escola.domain.model.base.EntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "departamento")
public class Departamento extends EntityBase {

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "departamento")
    private List<Curso> cursos;

    @OneToMany(mappedBy = "departamento")
    private List<Professor> professores;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Departamento that = (Departamento) o;
        return Objects.equals(nome, that.nome)
                && Objects.equals(cursos, that.cursos)
                && Objects.equals(professores, that.professores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                nome, cursos, professores);
    }

}
