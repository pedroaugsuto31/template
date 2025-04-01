package br.gov.ce.sps.template.config;

import br.gov.ce.sps.template.api.request.CursoRequest;
import br.gov.ce.sps.template.domain.model.Curso;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ModelMapperSkipSetId {
    /**
     * Configuração para evitar a exceção: "identifier of an instance altered from X to Y".
     * Necessário para entidades que tem apenas um relacionamento.
     */

    private final ModelMapper modelMapper;

    @PostConstruct
    public void configureMapping() {
        modelMapper.createTypeMap(CursoRequest.class, Curso.class)
                .addMappings(mapper -> mapper.skip(Curso::setId));
    }

}
