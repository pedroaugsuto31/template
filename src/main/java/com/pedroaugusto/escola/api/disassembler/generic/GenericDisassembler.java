package com.pedroaugusto.escola.api.disassembler.generic;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenericDisassembler {

    private final ModelMapper modelMapper;
    private final ModelMapper patchModelMapper;

    public <T, U> void copyToEntity(T request, U entity) {
        modelMapper.map(request, entity);
    }

    public <T, U> void copyToEntityPatch(T request, U entity) {
        patchModelMapper.map(request, entity);
    }

}
