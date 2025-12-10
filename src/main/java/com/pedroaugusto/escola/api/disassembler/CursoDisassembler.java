package com.pedroaugusto.escola.api.disassembler;

import com.pedroaugusto.escola.api.request.CursoRequest;
import com.pedroaugusto.escola.domain.model.Curso;
import com.pedroaugusto.escola.domain.model.Departamento;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CursoDisassembler {

    private final ModelMapper modelMapper;

    public void copyToEntity(CursoRequest request, Curso curso) {
        // Para evitar a exceção: "identifier of an instance of com.pedroaugusto.escola.domain.model.O was altered from X to Y".

        Optional.ofNullable(request.getDepartamentoId()).
                ifPresent(departamentoId -> curso.setDepartamento(new Departamento()));

        modelMapper.map(request, curso);
    }

}
