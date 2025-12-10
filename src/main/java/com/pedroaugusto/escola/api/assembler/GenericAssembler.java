package com.pedroaugusto.escola.api.assembler;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GenericAssembler {

    private final ModelMapper modelMapper;

    public <T, U> U toResponse(T entity, Class<U> modelClass) {
        return modelMapper.map(entity, modelClass);
    }

    public <T, U> List<U> toCollectionResponseList(List<T> entities, Class<U> response) {
        return entities.stream().map(entity -> toResponse(entity, response)).toList();
    }

    public <T, U> Set<U> toCollectionResponseSet(Set<T> entities, Class<U> response) {
        return entities.stream().map(entity -> toResponse(entity, response)).collect(Collectors.toSet());
    }

    public <T, U> U toEntity(T request, Class<U> entity) {
        return modelMapper.map(request, entity);
    }

}
