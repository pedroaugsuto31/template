package br.gov.ce.sps.template.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.getConfiguration().setCollectionsMergeEnabled(false);

        return modelMapper;
    }

    @Bean
    public ModelMapper patchModelMapper() {
        var patchModelMapper = new ModelMapper();

        patchModelMapper.getConfiguration().setAmbiguityIgnored(true);
        patchModelMapper.getConfiguration().setSkipNullEnabled(true);
        patchModelMapper.getConfiguration().setCollectionsMergeEnabled(false);

        return patchModelMapper;
    }

}
