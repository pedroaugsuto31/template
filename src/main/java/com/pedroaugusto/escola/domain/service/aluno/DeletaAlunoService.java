package com.pedroaugusto.escola.domain.service.aluno;

import com.pedroaugusto.escola.domain.model.Aluno;
import com.pedroaugusto.escola.domain.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletaAlunoService {

    private final AlunoRepository alunoRepository;
    private final BuscaAlunoService buscaAlunoService;

    @Transactional
    public void deletar(UUID codigo) {
        Aluno aluno = buscaAlunoService.findByCode(codigo);
        alunoRepository.delete(aluno);
    }

}
