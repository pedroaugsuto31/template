package com.pedroaugusto.escola.infrastructure.faker;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PopularBancoDeDados implements CommandLineRunner {

    private final FakerService fakerService;

    @Override
    public void run(String... args) {
        fakerService.populateAlunoTable(50);
        fakerService.populateTurmaTable(50);
        fakerService.populateDepartamentoTable(50);
        fakerService.populateDisciplinaTable(50);
    }

}
