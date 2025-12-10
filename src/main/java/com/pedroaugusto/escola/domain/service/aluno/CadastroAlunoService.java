package com.pedroaugusto.escola.domain.service.aluno;

import com.pedroaugusto.escola.domain.exception.CpfJaCadastradoException;
import com.pedroaugusto.escola.domain.model.Aluno;
import com.pedroaugusto.escola.domain.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CadastroAlunoService {

    private final AlunoRepository alunoRepository;

    @Transactional
    public Aluno salvar(Aluno aluno) {
        if (aluno.getCpf() != null && alunoRepository.existsByCpf(aluno.getCpf())) {
            throw new CpfJaCadastradoException("Já existe um Aluno cadastrado com o CPF informado");
        }

        return alunoRepository.save(aluno);
    }

}
