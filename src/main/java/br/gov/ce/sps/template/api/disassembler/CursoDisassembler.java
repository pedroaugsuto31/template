package br.gov.ce.sps.template.api.disassembler;

import br.gov.ce.sps.template.api.request.CursoRequest;
import br.gov.ce.sps.template.domain.model.Curso;
import br.gov.ce.sps.template.domain.model.Departamento;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CursoDisassembler {

    private final ModelMapper modelMapper;

    public void copyToEntity(CursoRequest request, Curso curso) {
        // Para evitar a exceção: "identifier of an instance of br.gov.ce.sps.template.domain.model.O was altered from X to Y".

        Optional.ofNullable(request.getDepartamentoId()).
                ifPresent(departamentoId -> curso.setDepartamento(new Departamento()));

        modelMapper.map(request, curso);
    }

}
